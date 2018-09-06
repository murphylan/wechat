package com.murphy.wechat.mini.security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDO {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String username;
	private String password;

	private ArrayList<String> roles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public UserDO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserDO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public UserDO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserDO setPassword(String password) {
		this.password = password;
		return this;
	}

	public List<String> getRoles() {
		return new ArrayList<>(roles);
	}

	public UserDO setRoles(List<String> roles) {
		this.roles = new ArrayList<>(roles);
		return this;
	}
}
