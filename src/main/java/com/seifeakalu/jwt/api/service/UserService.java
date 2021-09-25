package com.seifeakalu.jwt.api.service;


import com.seifeakalu.jwt.api.entity.AuthRequest;
import com.seifeakalu.jwt.api.entity.User;

public interface UserService {
	User saveUser(User user);
	String login(AuthRequest authRequest);
}
