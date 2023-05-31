package com.work.project01.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.project01.user.dto.UserRegisterDTO;
import com.work.project01.user.entity.UserRegister;
import com.work.project01.user.repository.UserRegisterRepository;

@Service
public class UserRegisterService {
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	@Transactional(readOnly = true)
	public List<UserRegisterDTO> findAll() {
		List<UserRegister> result = userRegisterRepository.findAll();
		return result.stream().map(x -> new UserRegisterDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public UserRegisterDTO findById(Long id) {
		UserRegister result = userRegisterRepository.findById(id).get();
		return new UserRegisterDTO(result);
	}
	
}
