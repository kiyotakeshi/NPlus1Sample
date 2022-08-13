package com.example.nplus1.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`order`") // escape reserved keyword
@Getter
@NamedEntityGraph(
        name = "order_all",
        attributeNodes = {
                @NamedAttributeNode(value = "orderDetails")
        }
)
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

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    protected Order(){
    }

    public Order(int totalPrice, LocalDateTime time, User user, Set<OrderDetail> orderDetails) {
        this.totalPrice = totalPrice;
        this.time = time;
        this.user = user;
        this.orderDetails = orderDetails;
    }
}
