package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.POJO.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	
	public Users findByUsername(String Username );
	
}
