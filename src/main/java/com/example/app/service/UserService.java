package com.example.app.service;

import com.example.app.entity.UserEntity;

import java.util.List;

public interface UserService  {
    List<UserEntity> getAllUsers();

    UserEntity saveUser(UserEntity user);

    UserEntity getUserById(Long id);
    UserEntity updateUser(UserEntity user);
}
