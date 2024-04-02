package com.inventory.app.service;

import java.util.List;

import com.inventory.app.dto.InventoryResponse;

public interface InventoryService {
	List<InventoryResponse> isInStock(String barcode);

}
