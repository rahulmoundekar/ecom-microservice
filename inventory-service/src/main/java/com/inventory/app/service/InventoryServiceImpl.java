package com.inventory.app.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.inventory.app.dto.InventoryResponse;
import com.inventory.app.dto.mapper.InventoryMapper;
import com.inventory.app.model.Inventory;
import com.inventory.app.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;

	@Override
	public List<InventoryResponse> isInStock(String barcode) {
		log.info("checking product is in stock or not");

		List<String> items = Stream.of(barcode.split(",")).map(String::trim).collect(Collectors.toList());

		List<Inventory> inventories = inventoryRepository.findAllByBarcodeIn(items);
		log.info("inventories is {}", inventories);
		List<InventoryResponse> list = inventories.stream()
				.map(inventory -> InventoryMapper.MAPPER.entityToInventoryResponseTranform(inventory))
				.collect(Collectors.toList());
		log.info("list is {}", list);
		return list;
	}

}
