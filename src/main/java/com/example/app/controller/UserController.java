package com.example.app.controller;

import com.example.app.entity.UserEntity;
import com.example.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") UserEntity user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
