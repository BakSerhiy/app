package com.example.app.controller;

import com.example.app.entity.UserEntity;
import com.example.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
    model.addAttribute("user",userService.getUserById(id));
    return "edit_user";
    }
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable long id ,@ModelAttribute("user") UserEntity userEntity, Model model ){
        UserEntity existingUser = userService.getUserById(id);
        existingUser.setUsername(userEntity.getUsername());
        existingUser.setLastname(userEntity.getLastname());
        existingUser.setEmail(userEntity.getEmail());

        userService.updateUser(existingUser);
        return "redirect:/users";

    }
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id ,RedirectAttributes redirectAttributes ){
        userService.deleteUserById(id);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/users";
    }
}
