package com.muratcimen.bookstore.service.impl;

import com.muratcimen.bookstore.dao.UserRepository;
import com.muratcimen.bookstore.entity.User;
import com.muratcimen.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User order) {
        User dbUser = userRepository.save(order);
        return dbUser;
    }
}
