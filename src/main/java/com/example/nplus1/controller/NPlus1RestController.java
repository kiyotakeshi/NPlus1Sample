package com.example.nplus1.controller;

import com.example.nplus1.dto.OrderDetailResponse;
import com.example.nplus1.dto.OrderResponse;
import com.example.nplus1.dto.UserResponse;
import com.example.nplus1.dto.UserWithRelationResponse;
import com.example.nplus1.entity.Order;
import com.example.nplus1.entity.User;
import com.example.nplus1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class NPlus1RestController {

    private final UserRepository userRepository;

    @GetMapping("/api/users")
    public List<UserResponse> users() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/users2")
    public List<UserWithRelationResponse> users2(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user ->
                        new UserWithRelationResponse(user.getId(), user.getName(), user.getEmail(),
                                user.getOrders().stream()
                                        .map(order -> new OrderResponse(order.getId(), order.getTotalPrice(), order.getTime(),
                                                order.getOrderDetails().stream()
                                                        .map(detail -> new OrderDetailResponse(detail.getId(), detail.getQuantity(), detail.getPrice())).collect(Collectors.toList()))
                                        )
                                        .collect(Collectors.toList()))
                ).collect(Collectors.toList());

//        ArrayList<UserWithRelationResponse> userResponses = new ArrayList<>();
//        for (User user : users) {
//            ArrayList<OrderResponse> orderResponses = new ArrayList<>();
//
//            for (Order order : user.getOrders()) {
//                orderResponses.add(new OrderResponse(order.getId(), order.getTotalPrice(), order.getTime(), order.getUser()));
//            }
//            userResponses.add(new UserWithRelationResponse(user.getId(), user.getName(), user.getEmail(), orderResponses));
//        }
//        return userResponses;
    }
}
