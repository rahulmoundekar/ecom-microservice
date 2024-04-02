package com.inventory.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	List<Inventory> findAllByBarcodeIn(List<String> barcode);

	Inventory findByBarcode(String barcode);

}
