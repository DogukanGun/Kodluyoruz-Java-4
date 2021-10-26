package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;

import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CheckoutDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Checkout;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCheckoutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {

    CheckoutMapper CHECKOUT_MAPPER = Mappers.getMapper(CheckoutMapper.class);

    CheckoutDto convertToCheckoutDto(Checkout checkout);

    Checkout convertToCheckout(CheckoutDto checkoutDto);

    Checkout createCheckout(UpdateCreateCheckoutRequest updateCreateCheckoutRequest);
}
