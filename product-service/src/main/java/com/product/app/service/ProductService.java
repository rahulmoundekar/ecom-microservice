package com.product.app.service;

import java.util.List;

import com.product.app.dto.ProductRequest;
import com.product.app.dto.ProductResponse;

public interface ProductService {
	public void createProduct(ProductRequest productRequest);

	public List<ProductResponse> products();

	public ProductResponse getByProductId(Integer id);
}
