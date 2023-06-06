package com.work.project01.userdata.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.project01.userdata.dto.UserDataDTO;
import com.work.project01.userdata.entity.UserData;
import com.work.project01.userdata.repository.UserDataRepository;

@Service
public class UserDataService {
	
	@Autowired
	private final UserDataRepository userRepository;
	
	public UserDataService(UserDataRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public List<UserDataDTO> findAll() {
		List<UserData> result = userRepository.findAll();
		return result.stream().map(x -> new UserDataDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public UserDataDTO findById(Long id) {
		UserData result = userRepository.findById(id).get();
		return new UserDataDTO(result);
	}
	
	@Transactional
	public void createUser(UserData user) {
		userRepository.save(user);
		return;
	}
	
	@Transactional
    public UserDataDTO editUser(Long id, UserDataDTO userDataDTO) {
		UserData user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
		user.setName(userDataDTO.getName());
		user.setEmail(userDataDTO.getEmail());
		user.setPassword(userDataDTO.getPassword());
        UserData updatedUser = userRepository.save(user);

        return new UserDataDTO(updatedUser);
    }
    
    @Transactional
    public void deleteUser(Long id) {
    	UserData user = userRepository.findById(id)
    			.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        userRepository.delete(user);
    }
	
    @Transactional(readOnly = true)
    public UserDataDTO findByEmail(String email) {
        UserData result = userRepository.findByEmail(email);
        if (result == null) {
            throw new NoSuchElementException("Usuário não encontrado com o e-mail: " + email);
        }
        return new UserDataDTO(result);
    }
	
}
