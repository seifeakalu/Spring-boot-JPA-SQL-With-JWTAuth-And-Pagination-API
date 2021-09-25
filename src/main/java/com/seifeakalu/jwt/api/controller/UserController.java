package com.seifeakalu.jwt.api.controller;
import com.seifeakalu.jwt.api.entity.AuthRequest;
import com.seifeakalu.jwt.api.entity.User;
import com.seifeakalu.jwt.api.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @GetMapping("/")
    public String welcome() {
    	
        return "Welcome to my app !!";
    }
    private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {        
         return userService.login(authRequest);
                   
    }
    
    @PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user){
    	return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
    
   
}
