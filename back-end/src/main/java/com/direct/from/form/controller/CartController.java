package com.direct.from.form.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.direct.from.form.model.Consumer;
import com.direct.from.form.model.Order;
import com.direct.from.form.model.OrderProduct;
import com.direct.from.form.model.Product;
import com.direct.from.form.payload.CartRequest;
import com.direct.from.form.payload.CartResponse;
import com.direct.from.form.payload.FarmerResponse;
import com.direct.from.form.payload.ProductResponse;
import com.direct.from.form.repository.ConsumerRepository;
import com.direct.from.form.repository.OrderProductRepository;
import com.direct.from.form.repository.OrderRepository;
import com.direct.from.form.repository.ProductRepository;
import com.direct.from.form.repository.UserRepository;
import com.direct.from.form.security.UserPrincipal;

@RestController
public class CartController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/cart")
	public ResponseEntity<CartResponse> getCart() {

		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Consumer consumer = consumerRepository.findByUser(userRepository.findById(userPrincipal.getId()).get());

		List<Order> existingOrders = orderRepository.findByConsumerAndStatus(consumer, "IN_CART");
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cart").buildAndExpand().toUri();
		if (existingOrders.size() == 0) {
			return ResponseEntity.created(location).body(new CartResponse());
		} else {
			Order existingOrder = existingOrders.get(0);
			return ResponseEntity.created(location).body(orderToCartResponse(existingOrder));
		}
	}

	@PostMapping("/cart")
	public ResponseEntity<CartResponse> addToCart(@RequestBody CartRequest cartRequest) {

		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Consumer consumer = consumerRepository.findByUser(userRepository.findById(userPrincipal.getId()).get());

		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setOrderedQuantity(cartRequest.getOrderedQuantity());
		orderProduct.setPacketPrice(cartRequest.getPackPrice());
		orderProduct.setPackPriceWithDiscount(cartRequest.getPackPriceWithDiscount());
		orderProduct.setAppliedDiscount(cartRequest.getDiscountOnPack());
		orderProduct.setAppliedDiscountType(cartRequest.getDiscountType());
		Product product = productRepository.findById(cartRequest.getProductId()).get();
		orderProduct.setProduct(product);
		orderProduct.setFarmer(product.getFarmer());
		Order order = null;
		List<Order> existingOrders = orderRepository.findByConsumerAndStatus(consumer, "IN_CART");
		if (existingOrders.size() == 0) {
			order = new Order();
			order.setStatus("IN_CART");
			order.setConsumer(consumer);
		} else {
			order = existingOrders.get(0);
		}
		order.getOrderProducts().add(orderProduct);
		order.setTotalPrice(cartRequest.getCartPrice());
		order.setTotalPriceWithDiscount(cartRequest.getCartPriceWithDiscount());
		order = orderRepository.save(order);
		
		orderProduct.setOrder(order);
		orderProductRepository.save(orderProduct);
		// Order savedOrder = orderRepository.save(order);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cart").buildAndExpand().toUri();

		return ResponseEntity.created(location).body(orderToCartResponse(order));
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
		productResponse.setRemainingPacks(product.getRemainingPacks());

		return productResponse;
	}

	private CartResponse orderToCartResponse(Order order) {
		CartResponse cartResponse = new CartResponse();

		cartResponse.setCartId(order.getId());
		cartResponse.setCartPrice(order.getTotalPrice());
		cartResponse.setCartPriceWithDiscount(order.getTotalPriceWithDiscount());

		List<ProductResponse> cartItems = new ArrayList<>();
		order.getOrderProducts().forEach((orderProduct) -> {

			ProductResponse pr = productToProductResponse(orderProduct.getProduct());
			pr.setOrderedQuantity(orderProduct.getOrderedQuantity());
			cartItems.add(pr);
		});
		cartResponse.setProducts(cartItems);

		return cartResponse;
	}
}
