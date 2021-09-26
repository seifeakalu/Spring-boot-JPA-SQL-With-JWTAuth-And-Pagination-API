package com.seifeakalu.jwt.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.seifeakalu.jwt.api.entity.Message;
import com.seifeakalu.jwt.api.entity.User;
import com.seifeakalu.jwt.api.exception.ResourceNotFoundException;
import com.seifeakalu.jwt.api.repository.MessageRepository;
import com.seifeakalu.jwt.api.repository.UserRepository;
import com.seifeakalu.jwt.api.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
   @Autowired
	private MessageRepository messageRepository;
    @Autowired
	private UserRepository userRepository;
	
	

	@Override
	public Message saveMessage(Message message, Long receiver_id) {
	        User receiver = userRepository.findById(receiver_id).get();
	        message.setReceiver(receiver);
		    return messageRepository.save(message);
	}

	@Override
	public Page<Message> getAllMessages(int pageNumber, int pageSize, long userId) {
		Pageable page= PageRequest.of(pageNumber, pageSize);
		return messageRepository.findAll(page);
	}

	@Override
	public Message getMessageById(long id) {

		return messageRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));
		
	}

	@Override
	public Message updateMessage(Message message, long id) {
	
		Message existingMessage = messageRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Message", "Id", id)); 
		System.out.println(message.getSubject());
		existingMessage.setMessage(message.getMessage());
		existingMessage.setSubject(message.getSubject());
		//existingMessage.setSender_id(message.getEmail());
		messageRepository.save(existingMessage);
		return existingMessage;
	}

	@Override
	public void deleteMessage(long id) {
		
	
		messageRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Message", "Id", id));
		messageRepository.deleteById(id);
	}
	
}
