package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User u = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(u.getUserrole());
		return builUser(u,authorities);
	}
	
	private User builUser(com.example.demo.entity.User user,List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(),true,true,true, authorities);
	}
	
	@SuppressWarnings("unused")
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UserRole ur:userRole) {
			auths.add(new SimpleGrantedAuthority(ur.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
}
