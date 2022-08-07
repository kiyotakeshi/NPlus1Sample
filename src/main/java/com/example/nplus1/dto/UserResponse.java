package com.example.nplus1.dto;

import lombok.Value;

@Value
public class UserResponse {
    private Long id;

    private String name;

    private String email;
}
