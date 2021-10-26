package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketItemDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.BasketItem;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketItemRequest;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketItemMapper {

    BasketItemMapper BASKET_ITEM_MAPPER = Mappers.getMapper(BasketItemMapper.class);

    BasketItemDto convertToBasketItemDto(BasketItem basketItem);

    BasketItem convertToBasketItem(BasketItemDto basketItemDto);

    List<BasketItemDto> convertToBasketItemList(List<BasketItem> basketItemList);

    BasketItem createBasketItem(UpdateCreateBasketItemRequest updateCreateBasketItemRequest);

    void updateBasketItem(@MappingTarget BasketItem basketItem,UpdateCreateBasketItemRequest updateCreateBasketItemRequest);
}
