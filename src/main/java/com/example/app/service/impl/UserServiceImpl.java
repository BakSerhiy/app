package com.example.app.service.impl;

import com.example.app.entity.UserEntity;
import com.example.app.repository.UserRepository;
import com.example.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository _userRepository;

    public UserServiceImpl(UserRepository _userRepository) {
        super();
        this._userRepository = _userRepository;
    }

    @Override
    public List<UserEntity> selectAllUserEntity() {
        return null;
    }
}
