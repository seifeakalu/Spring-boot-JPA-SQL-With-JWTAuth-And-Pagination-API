package com.seifeakalu.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seifeakalu.jwt.api.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

	
}
