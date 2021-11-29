package com.direct.from.form.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.direct.from.form.model.Consumer;
import com.direct.from.form.repository.ConsumerRepository;

@RestController
public class ConsumerController {
	@Autowired
	private ConsumerRepository consumerRepository;

	@GetMapping("/consumer/{id}")
	public ResponseEntity<Consumer> getConsumer(@PathVariable("id") Long id) {
		Consumer consumer = consumerRepository.findById(id).get();

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/consumer/")
				.buildAndExpand(consumer.getId()).toUri();

		return ResponseEntity.created(location).body(consumer);
	}
}
