package com.direct.from.form.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.direct.from.form.model.Consumer;
import com.direct.from.form.model.Order;
import com.direct.from.form.model.Product;
import com.direct.from.form.payload.FarmerResponse;
import com.direct.from.form.payload.OrderRequest;
import com.direct.from.form.payload.OrderResponse;
import com.direct.from.form.payload.ProductResponse;
import com.direct.from.form.repository.AddressRepository;
import com.direct.from.form.repository.ConsumerRepository;
import com.direct.from.form.repository.OrderRepository;
import com.direct.from.form.repository.ProductRepository;
import com.direct.from.form.repository.UserRepository;
import com.direct.from.form.security.UserPrincipal;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getOrders() {
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Consumer consumer = consumerRepository.findByUser(userRepository.findById(userPrincipal.getId()).get());

		List<Order> orders = orderRepository.findByConsumerAndStatusNot(consumer, "IN_CART");

		List<OrderResponse> orderResponses = new ArrayList<>();

		orders.forEach(order -> {
			orderResponses.add(orderToOrderResponse(order));
		});
		return ResponseEntity.ok(orderResponses);
	}

	@PatchMapping("/order/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable("id") Long orderId, @RequestBody OrderRequest orderRequest) {
		try {
			Order existingOrder = orderRepository.findById(orderId).get();

			existingOrder.setShippingAddress(addressRepository.findById(orderRequest.getAddressId()).get());
			existingOrder.setStatus(orderRequest.getStatus());
			existingOrder.setIsAmountPaid(true);
			existingOrder.setTotalPrice(orderRequest.getTotalPrice());
			existingOrder.setTotalPriceWithDiscount(orderRequest.getTotalPriceWithDiscount());
			existingOrder.setCreatedDate(Calendar.getInstance());

			Order orderPatched = orderRepository.save(existingOrder);

			orderPatched.getOrderProducts().forEach(orderProduct -> {
				Product product = orderProduct.getProduct();
				product.setRemainingPacks(product.getTotalPacks() - orderProduct.getOrderedQuantity());
				productRepository.save(product);
			});

			return ResponseEntity.ok(orderPatched);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	private ProductResponse productToProductResponse(Product product) {
		ProductResponse productResponse = new ProductResponse();

		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setDesription(product.getDescription());
		productResponse.setTotalPacks(product.getTotalPacks());

		productResponse.setPackUnit(product.getPackUnit());
		productResponse.setPackPrice(product.getPackPrice());
		productResponse.setPackQuantity(product.getPackQuantity());
		productResponse.setDiscountOnPack(product.getDiscountOnPack());
		productResponse.setDiscountType("PERCENTAGE");
		productResponse.setImageURL(product.getImageURL());

		FarmerResponse farmer = new FarmerResponse();
		farmer.setName("Janardhan");
		productResponse.setFarmer(farmer);

		productResponse.setPackPriceWithDiscount(product.getPackPriceWithDiscount());
		productResponse.setTotalPacksPrice(product.getTotalPacksPrice());
		productResponse.setTotalPacksPriceWithDiscount(product.getTotalPacksPriceWithDiscount());
		productResponse.setDefaultRating(3.25);
		productResponse.setMaxRating(5.0);
		product.setRemainingPacks(product.getRemainingPacks());

		return productResponse;
	}

	private OrderResponse orderToOrderResponse(Order order) {
		OrderResponse orderResponse = new OrderResponse();

		orderResponse.setId(order.getId());
		orderResponse.setTotalPrice(order.getTotalPrice());
		orderResponse.setTotalPriceWithDiscount(order.getTotalPriceWithDiscount());

		List<ProductResponse> products = new ArrayList<>();
		order.getOrderProducts().forEach((orderProduct) -> {

			ProductResponse pr = productToProductResponse(orderProduct.getProduct());
			pr.setOrderedQuantity(orderProduct.getOrderedQuantity());
			products.add(pr);
		});
		orderResponse.setStatus(order.getStatus());
		orderResponse.setProducts(products);
		orderResponse.setCreatedDate(order.getCreatedDate());
		return orderResponse;
	}

}
