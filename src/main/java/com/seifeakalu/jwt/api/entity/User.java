package com.seifeakalu.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@JsonIgnore
	@OneToMany(mappedBy = "sender")
	private Set<Message> messages;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private int id;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	public Set<Message> getMessages() {
		return this.messages;
	}
}
