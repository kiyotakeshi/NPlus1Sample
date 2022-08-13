package com.example.nplus1.entity;

import com.example.nplus1.repository.OrderRepository;
import com.example.nplus1.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EntitiesTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void newUser() {
        User user = new User("mike", "mike@example.com");
        em.persist(user);

        User user2 = em.find(User.class, 1L);
        assertThat(user2.getName()).isEqualTo("mike");
    }

    @Test
    void userFromInitData() {
        User user = userRepository.findById(100L).orElseThrow();

        assertThat(user.getName()).isEqualTo("kendrick");
        assertThat(user.getOrders().size()).isEqualTo(2);
        assertThat(user.getOrders().get(0).getTotalPrice()).isEqualTo(3_000);
        assertThat(user.getOrders().get(1).getTotalPrice()).isEqualTo(5_000);

        assertThat(user.getOrders().get(1).getOrderDetails().size()).isEqualTo(3);
        assertThat(user.getOrders().get(1).getOrderDetails().get(0).getItem().getName()).isEqualTo("battery");
    }

    @Test
    void orderFromInitData() {
        Order order = orderRepository.findById(100L).orElseThrow();

        assertThat(order.getOrderDetails().size()).isEqualTo(2);
        assertThat(order.getOrderDetails().get(0).getPrice()).isEqualTo(1000);

        Order order2 = orderRepository.findById(101L).orElseThrow();
        assertThat(order2.getOrderDetails().size()).isEqualTo(3);
        assertThat(order2.getOrderDetails().get(0).getPrice()).isEqualTo(3000);
        assertThat(order2.getOrderDetails().get(0).getItem().getName()).isEqualTo("battery");
    }

    @Test
    void mapping() {
        User mike = new User("mike", "mike@example.com");
        Item item = new Item("battery", 3_000);
        Item item2 = new Item("popcorn", 1_000);
        Item item3 = new Item("ice cream", 1_000);
        Item item4 = new Item("USB cable", 2_000);
        Item item5 = new Item("PC stand", 2_500);

        var order = new Order(3_000, LocalDateTime.of(2022, 8, 6, 15, 27, 10), mike, Set.of(
                new OrderDetail(1, 3_000, item)
        ));
        var order2 = new Order(2_000, LocalDateTime.of(2022, 8, 6, 22, 43, 10), mike, Set.of(
                new OrderDetail(2, 1_000, item2),
                new OrderDetail(2, 1_000, item3)
        ));
        var order3 = new Order(10_000, LocalDateTime.of(2022, 8, 6, 22, 44, 10), mike, Set.of(
                new OrderDetail(1, 1_000, item2),
                new OrderDetail(2, 4_000, item4),
                new OrderDetail(2, 5_000, item5)
        ));

        em.persist(mike);
        em.persist(order);
        em.persist(order2);
        em.persist(order3);

        List<Order> ordersByUser = orderRepository.findAllByUser(mike);
        assertThat(ordersByUser.size()).isEqualTo(3);

        assertThat(ordersByUser.get(0).getOrderDetails().size()).isEqualTo(1);
        assertThat(ordersByUser.get(1).getOrderDetails().size()).isEqualTo(2);
        assertThat(ordersByUser.get(2).getOrderDetails().size()).isEqualTo(3);

//        assertThat(ordersByUser.get(2).getOrderDetails().get(0).getPrice()).isEqualTo(1_000);
//        assertThat(ordersByUser.get(2).getOrderDetails().get(0).getItem().getName()).isEqualTo("popcorn");
    }
}
