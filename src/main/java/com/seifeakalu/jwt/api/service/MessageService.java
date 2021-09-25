package com.seifeakalu.jwt.api.service;

import org.springframework.data.domain.Page;

import com.seifeakalu.jwt.api.entity.Message;

public interface MessageService {
	Message saveMessage(Message employee, Long receiver_id);
	Page<Message> getAllMessages(int pageSize, int pageNumber, long userId);
	Message getMessageById(long id);
	Message updateMessage(Message employee, long id);
	void deleteMessage(long id);
}
