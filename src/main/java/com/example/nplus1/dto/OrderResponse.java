package com.example.nplus1.dto;

import com.example.nplus1.entity.OrderDetail;
import com.example.nplus1.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class OrderResponse {

    private Long id;

    private int totalPrice;

    private LocalDateTime time;

    private List<OrderDetailResponse> orderDetails;
}
