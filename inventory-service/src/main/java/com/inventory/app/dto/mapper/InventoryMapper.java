package com.inventory.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inventory.app.dto.InventoryResponse;
import com.inventory.app.model.Inventory;

@Mapper
public interface InventoryMapper {
	InventoryMapper MAPPER = Mappers.getMapper(InventoryMapper.class);

	default InventoryResponse entityToInventoryResponseTranform(Inventory inventory) {
		InventoryResponse inventoryResponse = new InventoryResponse();
		inventoryResponse.setBarcode(inventory.getBarcode());
		inventoryResponse.setAvailable(inventory.getQuantity() > 0);
		return inventoryResponse;
	}

}
