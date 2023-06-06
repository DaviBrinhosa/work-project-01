package com.work.project01.address.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.project01.address.dto.AddressDTO;
import com.work.project01.address.entity.Address;
import com.work.project01.address.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private final AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
    @Transactional
    public List<AddressDTO> listAddress() {
        List<Address> addresss = addressRepository.findAll();
        return addresss.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Transactional
    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Endereço não encontrado"));
        return mapToDTO(address);
    }

    @Transactional
    public AddressDTO createAddress(AddressDTO addressDTO) {
    	Address address = new Address();
        address.setStreetAddress(addressDTO.getStreetAddress());
        address.setCity(addressDTO.getCity());
        address.setZipCode(addressDTO.getZipCode());
        address.setDistrict(addressDTO.getDistrict());
        address.setComplement(addressDTO.getComplement());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setRegion(addressDTO.getRegion());
        address.setId(null);

        Address updatedAddress = addressRepository.save(address);
        return mapToDTO(updatedAddress);
    }

    @Transactional
    public AddressDTO editAddress(Long id, AddressDTO addressDTO) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Endereço não encontrado"));
        address.setStreetAddress(addressDTO.getStreetAddress());
        address.setCity(addressDTO.getCity());
        address.setZipCode(addressDTO.getZipCode());
        address.setDistrict(addressDTO.getDistrict());
        address.setComplement(addressDTO.getComplement());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setRegion(addressDTO.getRegion());

        Address updatedAddress = addressRepository.save(address);
        return mapToDTO(updatedAddress);
    }

    private AddressDTO mapToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setStreetAddress(address.getStreetAddress());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setDistrict(address.getDistrict());
        dto.setComplement(address.getComplement());
        dto.setBuildingNumber(address.getBuildingNumber());
        dto.setRegion(address.getRegion());

        return dto;
    }

    @SuppressWarnings("unused")
	private Address mapToEntity(AddressDTO dto) {
        Address address = new Address();
        address.setStreetAddress(dto.getStreetAddress());
        address.setCity(dto.getCity());
        address.setZipCode(dto.getZipCode());
        address.setDistrict(dto.getDistrict());
        address.setComplement(dto.getComplement());
        address.setBuildingNumber(dto.getBuildingNumber());
        address.setRegion(dto.getRegion());

        return address;
    }
}
