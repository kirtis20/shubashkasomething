package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	User createUser(User user);
	
	User getUserById(Long userId);  
	
	List<User> getAllUsers();
	
	User updateUser(User user);
	
	void deleteUser(Long userId);
	
	User saveUser(User user);
	
	public List<User> saveUsers(List<User> users);
	
	
}
