package com.example.nplus1.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails;

    protected Item() {
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
