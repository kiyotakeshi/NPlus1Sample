package com.example.nplus1.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`") // escape reserved keyword
@ToString
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalPrice;

    private LocalDateTime time;

    @ManyToOne
    // if you write explicitly
    // @JoinColumn(name = "user_id")
    private User user;

    protected Order(){
    }

    public Order(int totalPrice, LocalDateTime time, User user) {
        this.totalPrice = totalPrice;
        this.time = time;
        this.user = user;
    }
}
