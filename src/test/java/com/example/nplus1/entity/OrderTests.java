package com.example.nplus1.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

@DataJpaTest
class OrderTests {

    @Autowired
    TestEntityManager em;

    @Test
    void mapping() {
        em.persist(new Order(3_000, LocalDateTime.of(2022, 8, 6, 15, 2, 10)));
        Order order = em.find(Order.class, 1L);
        Order order2 = em.find(Order.class, 100L);
        System.out.println(order);
        System.out.println(order2);
    }
}