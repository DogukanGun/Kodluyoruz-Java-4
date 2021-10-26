package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketItemDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.BasketItem;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Product;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketItemRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.BasketItemRepository;
import com.kodluyoruz.dogukanaligundoganhm4.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.BasketItemMapper.BASKET_ITEM_MAPPER;
import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class BasketItemService {

    private final BasketItemRepository basketItemRepository;

    public BasketItemDto addBasketItemToBasket(UpdateCreateBasketItemRequest updateCreateBasketItemRequest){
        BasketItem basketItem = BASKET_ITEM_MAPPER.createBasketItem(updateCreateBasketItemRequest);
        return BASKET_ITEM_MAPPER.convertToBasketItemDto(basketItemRepository.save(basketItem));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BasketItemDto updateBasketItem(int id,UpdateCreateBasketItemRequest updateCreateBasketItemRequest){
        BasketItem basketItem = basketItemRepository.findById(id).orElseThrow(()->new NotFoundException("Basket Item cannot found"));
        BASKET_ITEM_MAPPER.updateBasketItem(basketItem,updateCreateBasketItemRequest);
        return BASKET_ITEM_MAPPER.convertToBasketItemDto(basketItemRepository.save(basketItem));
    }

    public void deleteBasketItemFromBasket(int id){
        basketItemRepository.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int incrementQuantity(int id){
        return basketItemRepository.incrementBasketItemCount(id);
    }

    public ProductDto getBasketItemProductInformation(int id){
        BasketItem basketItem = basketItemRepository.findById(id).orElseThrow(()->new NotFoundException("Basket Item cannot found"));
        return PRODUCT_MAPPER.convertToProductDao(basketItem.getProduct());
    }


}
