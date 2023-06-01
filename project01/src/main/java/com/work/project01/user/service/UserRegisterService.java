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
	private final UserRegisterRepository userRepository;
	
	public UserRegisterService(UserRegisterRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public List<UserRegisterDTO> findAll() {
		List<UserRegister> result = userRepository.findAll();
		return result.stream().map(x -> new UserRegisterDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public UserRegisterDTO findById(Long id) {
		UserRegister result = userRepository.findById(id).get();
		return new UserRegisterDTO(result);
	}
	
	public void createUser(UserRegister user) {
		userRepository.save(user);
		return;
	}
	
}
