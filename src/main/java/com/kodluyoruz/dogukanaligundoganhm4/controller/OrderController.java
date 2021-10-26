package com.kodluyoruz.dogukanaligundoganhm4.controller;

import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserOrderDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateOrderRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.BasketService;
import com.kodluyoruz.dogukanaligundoganhm4.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserOrderService orderService;
    private final BasketService basketService;

    @PostMapping
    public UserOrderDto order(@RequestBody UpdateCreateOrderRequest updateCreateOrderRequest,@RequestParam boolean status){
        UserOrderDto orderDto = orderService.createOrder(updateCreateOrderRequest);
        basketService.setOrder(orderDto.getBasketId(),status);
        return orderDto;
    }

    @GetMapping("user/{id}")
    public UserOrderDto getOrderByUser(@PathVariable int id){
        return orderService.getOrderByUserId(id);
    }

    @PatchMapping("cancel-order/{id}")
    public void cancelOrder(@PathVariable int id){
        orderService.cancelOrder(id);
    }
}
