package com.example.demo.entity;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="username",unique=true,nullable=false,length=45)
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="user")
	private Set<UserRole> userrole = new HashSet<>();
	
	public User(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, Set<UserRole> userrole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userrole = userrole;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserrole() {
		return userrole;
	}

	public void setUserrole(Set<UserRole> userrole) {
		this.userrole = userrole;
	}
	
	
	
}
