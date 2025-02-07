package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(Long userId) {
		return service.getUserById(userId);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	
	public User updateUser(User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(Long userId) {
		service.deleteUser(userId);
	}
	
	
	
	
	
	//////////////////////UI AND DB CONTROLLER////////////////////////////////////////
	@GetMapping("/adduser")
	public String addUser(Model model)
	{
		model.addAttribute("allusers", getAllUsers());
		return "adduser";
	}
	
	@GetMapping("/userform")
	public String userForm(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "userform";
		
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user")User user) {
		service.saveUser(user);
		return "redirect:/viewallusers";
	}
	@GetMapping("/viewallusers")
	public String viewAllUsers(Model model) {
		model.addAttribute("allusers", getAllUsers());
		return "viewallusers";
	}
	
	
	
}
