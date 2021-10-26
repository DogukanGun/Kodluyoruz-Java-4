package com.kodluyoruz.dogukanaligundoganhm4.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@SQLDelete(sql = "UPDATE orders SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class UserOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "user_id")
    private Integer userId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false,updatable = false,insertable = false)
    private User user;


    @Column(name = "basket_id")
    private Integer basketId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id",insertable = false,updatable = false)
    private Basket basket;

    @Column(name = "is_canceled")
    @Builder.Default
    private Boolean isCanceled=false;



}
