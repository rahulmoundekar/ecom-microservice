package com.order.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.order.app.dto.InventoryResponse;
import com.order.app.dto.OrderDto;
import com.order.app.mapper.OrderMapper;
import com.order.app.model.Order;
import com.order.app.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl {

	private final OrderRepository orderRepository;

	private final RestTemplate restTemplate;

	private final static String BASE_URL="http://localhost:32000";
	
	@Modifying
	public String placeOrder(OrderDto orderDto) {
		log.info("Received order request");
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderItems(
				orderDto.getOrderProducts().stream().map(OrderMapper.MAPPER::mapToEntity).collect(Collectors.toList()));

		String barcodes = orderDto.getOrderProducts().stream().map(a -> a.getBarcode())
				.collect(Collectors.joining(","));

		ResponseEntity<InventoryResponse[]> list = restTemplate
				.getForEntity(BASE_URL+"/api/inventory?barcodes=" + barcodes, InventoryResponse[].class);

		InventoryResponse[] inventoryResponses = list.getBody();

		Boolean result = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isAvailable);

		if (result) {
			orderRepository.saveAndFlush(order);
			return "Your Order is placed";
		} else {
			throw new IllegalArgumentException("Product is not avaiable, please try again");
		}
	}
}
