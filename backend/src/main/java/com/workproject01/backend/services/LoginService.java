package com.workproject01.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workproject01.backend.dto.LoginDTO;
import com.workproject01.backend.entities.Login;
import com.workproject01.backend.repositories.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Transactional(readOnly = true)
	public List<LoginDTO> findAll() {
		List<Login> result = loginRepository.findAll();
		return result.stream().map(x -> new LoginDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public LoginDTO findById(Long id) {
		Login result = loginRepository.findById(id).get();
		return new LoginDTO(result);
	}
	
}
