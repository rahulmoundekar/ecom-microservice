package com.product.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.dto.ProductRequest;
import com.product.app.dto.ProductResponse;
import com.product.app.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		log.info("Received createProduct request {}", productRequest);
		productService.createProduct(productRequest);
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductResponse> products() {
		log.info("Received products request");
		return productService.products();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ProductResponse productById(@PathVariable("id") Integer id) {
		log.info("Received products request {}", id);
		return productService.getByProductId(id);
	}

}
