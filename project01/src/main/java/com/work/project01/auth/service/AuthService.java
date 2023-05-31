package com.work.project01.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.project01.auth.dto.AuthDTO;
import com.work.project01.auth.entity.Auth;
import com.work.project01.auth.repository.AuthRepository;

@Service
public class AuthService {
	
	@Autowired
	private AuthRepository authRepository;
	
	@Transactional(readOnly = true)
	public List<AuthDTO> findAll() {
		List<Auth> result = authRepository.findAll();
		return result.stream().map(x -> new AuthDTO(x)).toList();
	}
	
}
