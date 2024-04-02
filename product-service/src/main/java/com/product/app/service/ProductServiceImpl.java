package com.product.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.app.dto.ProductRequest;
import com.product.app.dto.ProductResponse;
import com.product.app.dto.mapper.ProductMapper;
import com.product.app.model.Product;
import com.product.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void createProduct(ProductRequest productRequest) {
		Product product = ProductMapper.MAPPER.productRequestToEntity(productRequest);
		productRepository.save(product);
	}

	@Override
	public List<ProductResponse> products() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> ProductMapper.MAPPER.entityTOProductResponse(product))
				.collect(Collectors.toList());
	}

	@Override
	public ProductResponse getByProductId(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent())
			return ProductMapper.MAPPER.entityTOProductResponse(product.get());
		return null;
	}

}
