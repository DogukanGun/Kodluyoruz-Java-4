package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CheckoutDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.BasketItem;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Checkout;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCheckoutRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.CheckoutMapper.CHECKOUT_MAPPER;

@RequiredArgsConstructor
@Service
public class CheckoutService {
        private final CheckoutRepository checkoutRepository;


    public CheckoutDto createCheckout(UpdateCreateCheckoutRequest updateCreateCheckoutRequest){
        Checkout checkout = CHECKOUT_MAPPER.createCheckout(updateCreateCheckoutRequest);
        return CHECKOUT_MAPPER.convertToCheckoutDto(checkoutRepository.save(checkout));
    }

    public Integer getPrice(int id){
        Checkout checkout = checkoutRepository.findById(id).orElseThrow(()->new NotFoundException("Checkout cannot found"));
        int price=0;
        List<BasketItem> basketItems=checkout.getBasket().getBasketItems();
        for (BasketItem basketItem:
             basketItems) {
            price+=Integer.parseInt(basketItem.getProduct().getPrice())*basketItem.getQuantity();
        }
        return price;
    }

    public boolean makePurchase(int id,UpdateCreateCheckoutRequest updateCreateCheckoutRequest){
        Integer integer = getPrice(id);

        if (updateCreateCheckoutRequest.getMoneyPayed()>integer){
            Checkout checkout = checkoutRepository.findById(id).orElseThrow(()->new NotFoundException("Checkout cannot found"));
            checkout.setMadePurchase(true);
            checkoutRepository.save(checkout);
            return true;
        }else{
            return false;
        }

    }
}
