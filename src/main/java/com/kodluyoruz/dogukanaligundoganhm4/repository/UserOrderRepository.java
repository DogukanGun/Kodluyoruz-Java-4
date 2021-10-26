package com.kodluyoruz.dogukanaligundoganhm4.repository;

import com.kodluyoruz.dogukanaligundoganhm4.model.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder,Integer> {

    UserOrder findOrderByUserIdIs(int id);
}
