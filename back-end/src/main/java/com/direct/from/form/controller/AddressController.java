package com.direct.from.form.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.direct.from.form.model.Address;
import com.direct.from.form.model.User;
import com.direct.from.form.payload.AddressRequest;
import com.direct.from.form.repository.AddressRepository;
import com.direct.from.form.repository.ConsumerRepository;
import com.direct.from.form.repository.FarmerRepository;
import com.direct.from.form.repository.UserRepository;
import com.direct.from.form.security.UserPrincipal;

@RestController
public class AddressController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	@PostMapping("/address")
	public ResponseEntity<?> addAddress( @RequestBody AddressRequest addressRequest) {
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		
		User user = userRepository.findById(userPrincipal.getId()).get();
		Address address = mapAddressRequestToAddress(addressRequest);
		if (user.getUserType().equals("CONSUMER")) {
			address.setConsumerId(consumerRepository.findByUser(user).getId());
		} else {
			address.setFarmerId(farmerRepository.findByUser(user).getId());
		}

		addressRepository.save(address);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/address/")
				.buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(location).body(address);
	}

	private Address mapAddressRequestToAddress(AddressRequest addressRequest) {
		Address address = new Address();
		address.setHouseNumber(addressRequest.getHouseNumber());
		address.setRoad(addressRequest.getRoadNumber());
		address.setStreet(addressRequest.getStreet());
		address.setArea(addressRequest.getArea());
		address.setMandal(addressRequest.getMandal());
		address.setDistrict(addressRequest.getDistrict());
		address.setState(addressRequest.getState());
		address.setPinCode(addressRequest.getPincode());
		address.setLandMark(addressRequest.getLandMark());
		address.setPhoneNumber(addressRequest.getPhoneNumber());
		address.setAlternativeNumber(addressRequest.getAlternatePhoneNumber());

		return address;
	}
}
