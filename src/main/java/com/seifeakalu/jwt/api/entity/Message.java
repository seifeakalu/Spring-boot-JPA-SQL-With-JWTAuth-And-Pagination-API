package com.seifeakalu.jwt.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "subject", nullable = false)
	private String subject;

	@Column(name = "message")
	private String message;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sender_id", referencedColumnName = "id")
	private User sender;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receiver_id", referencedColumnName = "id")
	private User receiver;
	//private User user;
	public User getSender() {
		return sender;
	}
	
	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
}
