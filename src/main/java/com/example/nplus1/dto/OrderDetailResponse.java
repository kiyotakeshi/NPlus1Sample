package com.example.nplus1.dto;

import lombok.Value;

@Value
public class OrderDetailResponse {
    private Long id;

    private int quantity;

    private int price;
}
