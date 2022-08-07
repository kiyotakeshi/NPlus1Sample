package com.example.nplus1.dto;

import com.example.nplus1.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class OrderResponse {

    private Long id;

    private int totalPrice;

    private LocalDateTime time;

    @JsonBackReference
    private User user;
}
