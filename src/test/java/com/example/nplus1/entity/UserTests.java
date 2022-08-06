package com.example.nplus1.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class UserTests {

    @Autowired
    private TestEntityManager em;

    @Test
    void
    name() {
        em.persist(new User("mike", "mike@example.com"));
        User user = em.find(User.class, 1L);
        User user2 = em.find(User.class, 100L);
        System.out.println(user);
        System.out.println(user2);
    }
}