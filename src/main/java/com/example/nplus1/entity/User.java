package com.example.nplus1.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "`user`") // escape reserved keyword
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    protected User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
