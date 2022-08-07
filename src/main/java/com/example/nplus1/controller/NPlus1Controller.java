package com.example.nplus1.controller;

import com.example.nplus1.entity.User;
import com.example.nplus1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NPlus1Controller {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users2")
    public String users2(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users2";
    }
}
