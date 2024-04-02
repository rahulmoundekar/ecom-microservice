package com.inventory.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.dto.InventoryResponse;
import com.inventory.app.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam String barcodes) {
		log.info("Received inventory request for barcode validation : {}", barcodes);
		return inventoryService.isInStock(barcodes);
	}

}
