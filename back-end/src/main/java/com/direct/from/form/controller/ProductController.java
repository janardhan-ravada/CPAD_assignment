package com.direct.from.form.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.direct.from.form.model.Farmer;
import com.direct.from.form.model.Product;
import com.direct.from.form.payload.FarmerResponse;
import com.direct.from.form.payload.ProductRequest;
import com.direct.from.form.payload.ProductResponse;
import com.direct.from.form.repository.FarmerRepository;
import com.direct.from.form.repository.ProductRepository;
import com.direct.from.form.repository.UserRepository;
import com.direct.from.form.security.UserPrincipal;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {

		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Farmer farmer = farmerRepository.findByUser(userRepository.findById(userPrincipal.getId()).get());

		Product product = mapProductRequestToProduct(productRequest);
		product.setFarmer(farmer);
		productRepository.save(product);
		//URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/product").buildAndExpand(product.getId()).toUri();

		return ResponseEntity.ok("Created");
	}

	@GetMapping("/products")
	public List<ProductResponse> getProducts() {

		return productRepository.findAll().stream().map(product -> productToProductResponse(product))
				.collect(Collectors.toList());

	}

	private Product mapProductRequestToProduct(ProductRequest productRequest) {

		Product product = new Product();

		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPackQuantity(productRequest.getPackQuantity());
		product.setPackUnit(productRequest.getPackUnit());
		product.setPackPrice(productRequest.getPackPrice());
		product.setTotalPacks(productRequest.getTotalPacks());
		product.setDiscountOnPack(productRequest.getDiscountOnPack());
		product.setGrainType(null);
		product.setImageURL("https://5.imimg.com/data5/WY/JL/SF/SELLER-283756/basmati-rice-grains-500x500.jpg");
		product.setPackPriceWithDiscount(productRequest.getPackPriceWithDiscount());
		product.setTotalPacksPrice(productRequest.getTotalPacksPrice());
		product.setTotalPacksPriceWithDiscount(productRequest.getTotalPacksPriceWithDiscount());
		product.setRemainingPacks(productRequest.getTotalPacks());
		return product;

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
		if(product.getFarmer()!=null) {
			farmer.setName(product.getFarmer().getName());
		}else {
			farmer.setName("Janardhan");
		}
		
		productResponse.setFarmer(farmer);

		productResponse.setPackPriceWithDiscount(product.getPackPriceWithDiscount());
		productResponse.setTotalPacksPrice(product.getTotalPacksPrice());
		productResponse.setTotalPacksPriceWithDiscount(product.getTotalPacksPriceWithDiscount());
		productResponse.setDefaultRating(3.25);
		productResponse.setMaxRating(5.0);
		productResponse.setRemainingPacks(product.getRemainingPacks());

		return productResponse;
	}
}
