package com.work.project01.userdata.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.work.project01.auth.aesutil.AESUtil;
import com.work.project01.userdata.dto.UserDataDTO;
import com.work.project01.userdata.entity.UserData;
import com.work.project01.userdata.service.UserDataService;

@RestController
@RequestMapping(value = "/userData")
public class UserDataController {
	
    String key = AESUtil.getKey();
    
	private AESUtil aESUtil = new AESUtil();

	protected AESUtil getAESUtil() {
		return aESUtil;
	}
	
	@Autowired
	private final UserDataService userService;
	
	public UserDataController(UserDataService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserDataDTO> findAll() {
		List<UserDataDTO> result = userService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public UserDataDTO findById(@PathVariable Long id) {
		UserDataDTO result = userService.findById(id);
		return result;
	}	
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserData user) {
        try {
    		String decryptEmail = getAESUtil().decrypt(key, user.getEmail());
    		String decryptName = getAESUtil().decrypt(key, user.getName());
    		user.setEmail(decryptEmail);
    		user.setName(decryptName);
    		
    		if(userService.validateEmail(decryptEmail) == true) {
    			String invalidMessage = "Usuário já cadastrado.";
                return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(invalidMessage);
    		} else {
    			userService.createUser(user);
    			return ResponseEntity.ok("Usuário cadastrado com sucesso! Efetue seu login.");
    		}
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Favor tentar novamente o cadatro.");
        }
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable Long id, @RequestBody UserDataDTO userDTO) {
    	String decryptEmail = getAESUtil().decrypt(key, userDTO.getEmail());
		String decryptName = getAESUtil().decrypt(key, userDTO.getName());
    	userDTO.setEmail(decryptEmail);
		userDTO.setName(decryptName);
    	
    	userService.editUser(id, userDTO);
    	return ResponseEntity.ok("Usuário editado com sucesso!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    	userService.deleteUser(id);
    	return ResponseEntity.ok("Usuário deletado com sucesso!");
    }
	
	@PostMapping(value = "/auth")
    public ResponseEntity<String> authenticateUser(@RequestBody UserDataDTO request) {
        
		String requestEmail = getAESUtil().decrypt(key, request.getEmail());
		String requestPassword = getAESUtil().decrypt(key, request.getPassword());
           
        try {
            UserDataDTO user = userService.findByEmail(requestEmail);
                      
    		String decryptPassBase = getAESUtil().decrypt(key, user.getPassword());
    		
            // Verificar se a senha fornecida corresponde à senha armazenada para o usuário
            if (decryptPassBase.equals(requestPassword)) {
                Long hashedId = user.getId();
                String hashedName = getAESUtil().encrypt(key, user.getName());
                String hashedEmail = getAESUtil().encrypt(key, user.getEmail());
                
        		JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id", hashedId);
                jsonObject.addProperty("name", hashedName);
                jsonObject.addProperty("email", hashedEmail);
        		
        		Gson gson = new Gson();
                String messageJSON = gson.toJson(jsonObject);
            	
                return ResponseEntity.ok(messageJSON);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado. Favor refazer o login");
        }
    }
	
}
