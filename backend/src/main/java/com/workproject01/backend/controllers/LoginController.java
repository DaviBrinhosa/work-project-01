package com.workproject01.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workproject01.backend.dto.LoginDTO;
import com.workproject01.backend.dto.LoginRequestDTO;
import com.workproject01.backend.services.LoginService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveLoginPost(@RequestBody LoginRequestDTO data) {
		loginService.save(data);
		return;		
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<LoginDTO> findAll() {
		List<LoginDTO> result = loginService.findAll();
		return result;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/{id}")
	public LoginDTO findById(@PathVariable Long id) {
		LoginDTO result = loginService.findById(id);
		return result;
	}
}
