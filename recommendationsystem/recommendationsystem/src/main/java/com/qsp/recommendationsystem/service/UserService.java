package com.qsp.recommendationsystem.service;

import java.util.List;

import com.qsp.recommendationsystem.model.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
	List<User> getAllUsers();
}
