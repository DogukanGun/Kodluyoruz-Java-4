package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketItemDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Basket;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketItemRequest;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketRequest;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateOrderRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.BasketItemMapper.BASKET_ITEM_MAPPER;
import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.BasketMapper.BASKET_MAPPER;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;


    public BasketDto createBasket(UpdateCreateBasketRequest updateCreateBasketRequest){
        Basket basket = BASKET_MAPPER.createBasketItem(updateCreateBasketRequest);
        return BASKET_MAPPER.convertToBasketDto(basketRepository.save(basket));
    }


    public void setOrder(int id, boolean status){
        Basket basket=basketRepository.findById(id).orElseThrow(()->new NotFoundException("Basket cannot found"));
        basket.setIsOrdered(status);
        basketRepository.save(basket);
    }
    public void deleteBasket(int id){
        basketRepository.deleteById(id);
    }

    public List<BasketItemDto> getBasketItemsInBasket(int id){
        Basket basket = basketRepository.findById(id).orElseThrow(()->new NotFoundException("Basket cannot found"));
        return BASKET_ITEM_MAPPER.convertToBasketItemList(basket.getBasketItems());
    }

//    public List<BasketItemDto> getBasketItemInBasketByUser(UpdateCreateBasketRequest updateCreateBasketRequest){
//        Basket basket = basketRepository.findByUserIdInAnAndIsOrderedEquals(updateCreateBasketRequest.getUserId(),false);
//        return BASKET_ITEM_MAPPER.convertToBasketItemList(basket.getBasketItems());
//    }


}
