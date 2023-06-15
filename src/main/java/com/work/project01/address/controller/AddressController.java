package com.work.project01.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.project01.address.dto.AddressDTO;
import com.work.project01.address.service.AddressService;
import com.work.project01.configuration.aesutil.AESUtil;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
	
String key = AESUtil.getKey();
    
	private AESUtil aESUtil = new AESUtil();

	protected AESUtil getAESUtil() {
		return aESUtil;
	}
	
	@Autowired
	private final AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping
    public List<AddressDTO> listAddress() {
        return addressService.listAddress();
    }

    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }

    @PutMapping("/{id}")
    public AddressDTO editAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        return addressService.editAddress(id, addressDTO);
    }
}
