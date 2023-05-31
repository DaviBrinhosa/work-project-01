package com.work.project01.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.project01.user.dto.UserRegisterDTO;
import com.work.project01.user.service.UserRegisterService;

@RestController
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@GetMapping(value = "/user")
	public List<UserRegisterDTO> findAll() {
		List<UserRegisterDTO> result = userRegisterService.findAll();
		return result;
	}

}
