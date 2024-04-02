package com.order.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.order.app.dto.OrderedProductDto;
import com.order.app.model.OrderItems;

@Mapper
public interface OrderMapper {
	OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

	@Mapping(target = "barcode", source = "barcode")
	@Mapping(target = "price", source = "price")
	@Mapping(target = "quantity", source = "quantity")
	OrderItems mapToEntity(OrderedProductDto orderedProductDto);

}
