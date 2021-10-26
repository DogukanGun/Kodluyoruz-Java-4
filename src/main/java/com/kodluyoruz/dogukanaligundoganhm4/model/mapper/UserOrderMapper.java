package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserOrderDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.User;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.UserOrder;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserOrderMapper {
    UserOrderMapper USER_ORDER_MAPPER = Mappers.getMapper(UserOrderMapper.class);

    UserOrder convertToUserOrder(UserOrderDto userOrderDto);

    UserOrderDto convertToUserOrderDto(UserOrder userOrder);

    void updateUserOrder(@MappingTarget UserOrder userOrder, UpdateCreateOrderRequest updateCreateOrderRequest);

    UserOrder createUserOrder(UpdateCreateOrderRequest updateCreateOrderRequest);

}
