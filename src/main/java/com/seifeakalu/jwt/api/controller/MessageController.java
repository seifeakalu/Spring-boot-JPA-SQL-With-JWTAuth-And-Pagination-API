package com.seifeakalu.jwt.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seifeakalu.jwt.api.entity.Message;
import com.seifeakalu.jwt.api.entity.User;
import com.seifeakalu.jwt.api.service.MessageService;
import com.seifeakalu.jwt.api.util.JwtUtil;


@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/{receiverId}", method = RequestMethod.POST)
	public ResponseEntity<Message> saveMessage(@RequestBody Message message, @PathVariable Long receiverId){
		return new ResponseEntity<Message>(messageService.saveMessage(message,receiverId), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public Page<Message> getAllMessages(@RequestParam int pageSize, @RequestParam int pageNumber,HttpServletRequest httpServletRequest){		
		 
		String token=jwtUtil.generateToken(httpServletRequest);
		User user = jwtUtil.parseToken(token);
		System.out.println(user);
		return messageService.getAllMessages(pageNumber,pageSize,user.getId());
	}
	

	@GetMapping("{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable("id") long messageId){
		return new ResponseEntity<Message>(messageService.getMessageById(messageId), HttpStatus.OK);
	}
	

	@PutMapping("{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable("id") long id
												  ,@RequestBody Message employee){
		return new ResponseEntity<Message>(messageService.updateMessage(employee, id), HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMessage(@PathVariable("id") long id){
		
		// delete employee from DB
		messageService.deleteMessage(id);
		
		return new ResponseEntity<String>("Message deleted successfully!.", HttpStatus.OK);
	}
	
	 
	  
	  
}
