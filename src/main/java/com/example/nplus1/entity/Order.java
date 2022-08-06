package com.example.nplus1.entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`") // escape reserved keyword
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalPrice;

    private LocalDateTime time;

    protected Order(){

    }

    public Order(int totalPrice, LocalDateTime time) {
        this.totalPrice = totalPrice;
        this.time = time;
    }
}
