package com.kodluyoruz.dogukanaligundoganhm4.controller;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.BasketItemDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateBasketRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @GetMapping("{id}")
    public List<BasketItemDto> getAllBasketItemInDto(@PathVariable int id){
        return basketService.getBasketItemsInBasket(id);
    }

    @PostMapping
    public BasketDto createBasket(@RequestBody UpdateCreateBasketRequest updateCreateBasketRequest){
        return basketService.createBasket(updateCreateBasketRequest);
    }

    @DeleteMapping("{id}")
    public void deleteBasket(@PathVariable int id){
        basketService.deleteBasket(id);
    }

//    @GetMapping("{id}/user")
//    public List<BasketItemDto> getAllBasketItemsInBasketByUser(UpdateCreateBasketRequest updateCreateBasketRequest){
//        return basketService.getBasketItemInBasketByUser(updateCreateBasketRequest);
//    }
}
