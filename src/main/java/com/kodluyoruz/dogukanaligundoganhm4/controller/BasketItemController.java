package com.kodluyoruz.dogukanaligundoganhm4.controller;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketItemDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketItemRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basket-item")
@RequiredArgsConstructor
public class BasketItemController {
    private final BasketItemService basketItemService;

    @PostMapping
    public BasketItemDto addBasketItemToBasket(@RequestBody UpdateCreateBasketItemRequest updateCreateBasketItemRequest){
        return basketItemService.addBasketItemToBasket(updateCreateBasketItemRequest);
    }

    @PutMapping("{id}")
    public BasketItemDto updateBasketItem(@PathVariable int id,@RequestBody UpdateCreateBasketItemRequest updateCreateBasketItemRequest){
        return basketItemService.updateBasketItem(id,updateCreateBasketItemRequest);
    }

    @DeleteMapping("{id}")
    public void deleteBasketItem(@PathVariable int id){
        basketItemService.deleteBasketItemFromBasket(id);
    }

    @PostMapping("{id}/increment")
    public int incrementBasketItemQuantity(@PathVariable int id){
        return basketItemService.incrementQuantity(id);
    }

    @GetMapping("{id}/product-detail")
    public ProductDto getProductDetail(@PathVariable int id){
        return basketItemService.getBasketItemProductInformation(id);
    }

}
