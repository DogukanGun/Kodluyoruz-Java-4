package com.kodluyoruz.dogukanaligundoganhm4.repository;

import com.kodluyoruz.dogukanaligundoganhm4.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
//    @Modifying(clearAutomatically = true)
//    @Query("Update #{#entityName} b set b.isDeleted= :isDeleted where b.id= :id")
//    int setDelete(@Param("id") Integer id, @Param("isDeleted") boolean isDeleted);
}
