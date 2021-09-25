package com.seifeakalu.jwt.api.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.seifeakalu.jwt.api.entity.AuthRequest;
import com.seifeakalu.jwt.api.entity.User;
import com.seifeakalu.jwt.api.repository.UserRepository;
import com.seifeakalu.jwt.api.service.UserService;
import com.seifeakalu.jwt.api.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private JwtUtil jwtUtil;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		User userExist = userRepository.findByUserName(user.getUserName());
		if(userExist != null) {
			throw new RuntimeException("This username already exist.");
		}
		user.setPassword(generateHash(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public String login(AuthRequest authRequest) {

		User user = userRepository.findByUserName(authRequest.getUserName());
		if(user == null) {
			throw new RuntimeException("User does not exist.");
		}

		if(bCryptPasswordEncoder.matches(authRequest.getPassword(), user.getPassword())){           
            
			return jwtUtil.generateToken(user.getId(),user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail());
		}else {
			throw new RuntimeException("Password mismatch.");
		}


	}

	public String generateHash(String password){

		return bCryptPasswordEncoder.encode(password);
		
	}


}
