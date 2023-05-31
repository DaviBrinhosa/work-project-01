package com.work.project01.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.project01.auth.dto.AuthDTO;
import com.work.project01.auth.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping(value = "/auth")
	public List<AuthDTO> findAll() {
		List<AuthDTO> result = authService.findAll();
		return result;
	}

}
