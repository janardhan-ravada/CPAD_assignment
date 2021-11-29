package com.direct.from.form.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.direct.from.form.exception.BadRequestException;
import com.direct.from.form.model.AuthProvider;
import com.direct.from.form.model.Consumer;
import com.direct.from.form.model.Farmer;
import com.direct.from.form.model.User;
import com.direct.from.form.payload.ApiResponse;
import com.direct.from.form.payload.AuthResponse;
import com.direct.from.form.payload.LoginRequest;
import com.direct.from.form.payload.SignUpRequest;
import com.direct.from.form.repository.ConsumerRepository;
import com.direct.from.form.repository.FarmerRepository;
import com.direct.from.form.repository.UserRepository;
import com.direct.from.form.security.TokenProvider;
import com.direct.from.form.security.UserPrincipal;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private ConsumerRepository consumerRepository;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		User user = userRepository.findById(userPrincipal.getId()).get();
		return ResponseEntity.ok(new AuthResponse(token, user.getUserType()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}

		// Creating user's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		user.setUserType(signUpRequest.getUserType());

		user.setProvider(AuthProvider.local);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User result = userRepository.save(user);

		if (signUpRequest.getUserType().equalsIgnoreCase("FARMER")) {
			Farmer farmer = new Farmer();
			farmer.setUser(result);
			farmer.setName(signUpRequest.getName());
			farmer.setEnterpriseName(signUpRequest.getEnterpriseName());
			farmerRepository.save(farmer);
		} else {
			Consumer consumer = new Consumer();
			consumer.setUser(result);
			consumer.setName(signUpRequest.getName());
			consumerRepository.save(consumer);
		}

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully@"));
	}

}
