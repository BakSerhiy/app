package com.example.app.controller;

import com.example.app.entity.UserEntity;
import com.example.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }
    @GetMapping("/users")
    public String ListUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
    @GetMapping("/users/new")
    public String createUserForm(Model model){
        UserEntity user = new UserEntity();
        model.addAttribute("user",user);
        return "create_user";
    }
}
