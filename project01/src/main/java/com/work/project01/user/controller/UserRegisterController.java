package com.work.project01.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.project01.user.dto.UserRegisterDTO;
import com.work.project01.user.entity.UserRegister;
import com.work.project01.user.service.UserRegisterService;

@RestController
@RequestMapping(value = "/userRegister")
public class UserRegisterController {
	
	@Autowired
	private final UserRegisterService userService;
	
	public UserRegisterController(UserRegisterService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserRegisterDTO> findAll() {
		List<UserRegisterDTO> result = userService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public UserRegisterDTO findById(@PathVariable Long id) {
		UserRegisterDTO result = userService.findById(id);
		return result;
	}
	
	@PostMapping(value = "/postUser")
	public ResponseEntity<String> createUser(@RequestBody UserRegister user) {
		userService.createUser(user);
		return ResponseEntity.ok("Usuario Cadastrado");
	}
}
