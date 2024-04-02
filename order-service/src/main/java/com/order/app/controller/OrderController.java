package com.order.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.dto.OrderDto;
import com.order.app.service.OrderServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

	private final OrderServiceImpl orderService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public String placeOrder(@RequestBody OrderDto orderDto) {
		log.info("Received order request in controller {}",orderDto);
		return orderService.placeOrder(orderDto);
	}

}
