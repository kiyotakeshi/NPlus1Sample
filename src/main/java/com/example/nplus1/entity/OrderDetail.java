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

    @ManyToOne
    private Item item;

    protected OrderDetail() {
    }

    public OrderDetail(int quantity, int price, Item item) {
        this.quantity = quantity;
        this.price = price;
        this.item = item;
    }
}
