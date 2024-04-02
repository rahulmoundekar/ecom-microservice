package com.order.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
	private String barcode;
	private boolean isAvailable;
	
	@Override
	public String toString() {
		return "InventoryResponse [barcode=" + barcode + ", isAvailable=" + isAvailable + "]";
	}
	
	
}
