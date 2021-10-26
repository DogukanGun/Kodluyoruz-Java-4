package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketDto;
 import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Basket;
 import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketRequest;
import org.mapstruct.Mapper;
 import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketMapper {

    BasketMapper BASKET_MAPPER = Mappers.getMapper(BasketMapper.class);

    BasketDto convertToBasketDto(Basket basket);

    Basket convertToBasket(BasketDto basketDto);

    List<BasketDto> convertToBasketItemList(List<Basket> baskets);

    Basket createBasketItem(UpdateCreateBasketRequest updateCreateBasketRequest);

 }
