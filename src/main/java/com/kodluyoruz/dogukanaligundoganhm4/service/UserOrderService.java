package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserOrderDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.UserOrder;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateOrderRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.UserOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.UserOrderMapper.USER_ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;

    public UserOrderDto createOrder(UpdateCreateOrderRequest updateCreateOrderRequest){
        UserOrder order = USER_ORDER_MAPPER.createUserOrder(updateCreateOrderRequest);
        return USER_ORDER_MAPPER.convertToUserOrderDto(userOrderRepository.save(order));
    }

    public UserOrderDto updateOrder(int id,UpdateCreateOrderRequest updateCreateOrderRequest){
        UserOrder order = userOrderRepository.findById(id).orElseThrow(()->new NotFoundException("Order cannot found"));
        return USER_ORDER_MAPPER.convertToUserOrderDto(userOrderRepository.save(order));
    }

    public UserOrderDto getOrderByUserId(int id){
        return USER_ORDER_MAPPER.convertToUserOrderDto(userOrderRepository.findOrderByUserIdIs(id));
    }
//    public void deleteOrder(int id){
//        userOrderRepository.deleteById(id);
//    }

    public void cancelOrder(int id) {
        UserOrder order = userOrderRepository.findById(id).orElseThrow(()->new NotFoundException("Order cannot found"));
        order.setIsCanceled(true);
        userOrderRepository.save(order);
    }
}
