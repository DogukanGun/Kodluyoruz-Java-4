package com.kodluyoruz.dogukanaligundoganhm4.repository;

import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

//    Basket findByUserIdInAnAndIsOrderedEquals(int id, boolean isOrdered);
}
