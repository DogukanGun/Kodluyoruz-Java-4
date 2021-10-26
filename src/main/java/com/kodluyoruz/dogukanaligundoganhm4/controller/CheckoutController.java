package com.kodluyoruz.dogukanaligundoganhm4.controller;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CheckoutDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCheckoutRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("checkout")
@RequiredArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;


    @PostMapping
    public CheckoutDto createCheckout(@RequestBody UpdateCreateCheckoutRequest updateCreateCheckoutRequest){
        return checkoutService.createCheckout(updateCreateCheckoutRequest);
    }

    @GetMapping("{id}/price")
    public Integer getPrice(@PathVariable int id){
        return checkoutService.getPrice(id);
    }

    @PostMapping("{id}/make-purchase")
    public boolean makePurchase(@PathVariable int id,@RequestBody UpdateCreateCheckoutRequest updateCreateCheckoutRequest){
        return checkoutService.makePurchase(id,updateCreateCheckoutRequest);
    }

}
