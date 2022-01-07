package com.example.demo.service;

import com.example.demo.persistence.User;

public interface UserService {

	User getUser(String email, String password);
	User getUserById(Long id);
}
