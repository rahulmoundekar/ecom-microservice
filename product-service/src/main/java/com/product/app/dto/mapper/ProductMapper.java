package com.product.app.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.product.app.dto.ProductRequest;
import com.product.app.dto.ProductResponse;
import com.product.app.model.Product;

@Mapper
public interface ProductMapper {
	ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

	Product productRequestToEntity(ProductRequest productRequest);

	ProductResponse entityTOProductResponse(Product product);
}
