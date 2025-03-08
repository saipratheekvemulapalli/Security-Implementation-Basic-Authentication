package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.POJO.Users;
import com.example.demo.repo.UsersRepo;

@Service
public class userService implements UserDetailsService{
	
	@Autowired
	UsersRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userrepo.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("username not found");
		}
		
		
		
		return new UserPrincipal(user);
	}

}
