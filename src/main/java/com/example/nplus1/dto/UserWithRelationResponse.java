package com.example.nplus1.dto;

import com.example.nplus1.entity.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Value;

import java.util.List;

@Value
public class UserWithRelationResponse {
    private Long id;

    private String name;

    private String email;

    private List<OrderResponse> orders;
}
