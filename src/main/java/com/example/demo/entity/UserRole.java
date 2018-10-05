package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="userrole",uniqueConstraints = @UniqueConstraint(columnNames= {"role","username"}))
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name="userroleId",unique=true,nullable=false)
	private Integer userroleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="username",nullable=false)
	private User user;
	
	@Column(name="role",nullable=false, length=45)
	private String role;
	
	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	
	public UserRole() {}

	public Integer getUserroleId() {
		return userroleId;
	}

	public void setUserroleId(Integer userroleId) {
		this.userroleId = userroleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
