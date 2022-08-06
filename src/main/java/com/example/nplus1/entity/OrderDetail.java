package com.example.nplus1.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private int price;

    @ManyToOne
    private Order order;

    protected OrderDetail() {
    }

    public OrderDetail(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }
}
