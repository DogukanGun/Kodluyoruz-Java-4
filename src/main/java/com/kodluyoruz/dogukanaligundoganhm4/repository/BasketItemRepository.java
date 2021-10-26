package com.kodluyoruz.dogukanaligundoganhm4.repository;

import com.kodluyoruz.dogukanaligundoganhm4.model.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem,Integer> {
    @Query(value = "update #{#entityName} u set u.quantity= u.quantity+1 where u.id= :id")
    @Modifying(clearAutomatically = true)
    int incrementBasketItemCount(@Param("id") Integer id);
//
//    @Modifying(clearAutomatically = true)
//    @Query("Update #{#entityName} b set b.isDeleted= :isDeleted where b.id= :id")
//    int setDelete(@Param("id") Integer id, @Param("isDeleted") boolean isDeleted);
}
