package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class UserController {
	
	@Autowired
	UserService service;

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(Long userId) {
		return service.getUserById(userId);
	}
	
	@GetMapping("/userform")
	public String userform(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "userform";
		
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") User user) {
		service.saveUser(user);
		return "redirect:/viewallusers";
	}
	
	@GetMapping("/viewallusers")
	public String viewAllUsers(Model model) {
		model.addAttribute("allusers",getAllUsers());
		return "viewallusers";
	}


	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		model.addAttribute("allusers",getAllUsers());
		return "adduser";
	}
	
	@GetMapping("/updateuser")
	public String updateUser(Model model) {
		model.addAttribute("allusers",getAllUsers());
		return "updateuser";
	}
	
	@GetMapping("/updateuserform")
	public String updateUserForm(Model model) {
		User User = new User();
		model.addAttribute("user",User);
		return "updateuserform";
	}
	
	@PostMapping("/saveupdateuser")
	public String saveUpdateUser(@ModelAttribute("user") User user) {
		service.updateUser(user);
		return "redirect:/viewallusers";
	}

	@GetMapping("/deleteuser/{userId}")
	public String deleteUser(Model model, @PathVariable Long userId) {
		service.deleteUser(userId);
		return "redirect:/viewallusers";
	}
	

}