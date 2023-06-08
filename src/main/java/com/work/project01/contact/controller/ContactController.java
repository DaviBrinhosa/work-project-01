package com.work.project01.contact.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work.project01.address.dto.AddressDTO;
import com.work.project01.address.entity.Address;
import com.work.project01.auth.aesutil.AESUtil;
import com.work.project01.contact.dto.ContactDTO;
import com.work.project01.contact.entity.Contact;
import com.work.project01.contact.service.ContactService;
import com.work.project01.userdata.entity.UserData;

@RestController
@RequestMapping("/contacts/{userId}")
public class ContactController {
	
String key = AESUtil.getKey();
    
	private AESUtil aESUtil = new AESUtil();

	protected AESUtil getAESUtil() {
		return aESUtil;
	}
	
	@Autowired
	private final ContactService contactService;
	
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping
    public ResponseEntity<List<ContactDTO>> contactListByUserId(@PathVariable Long userId) {
    	try {
	        List<Contact> contacts = contactService.contactListByUserId(userId);
	        List<ContactDTO> contactsDTO = convertToDTO(contacts);
	        return ResponseEntity.ok(contactsDTO);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @GetMapping("/list")
    public ResponseEntity<Page<ContactDTO>> findByUserIdList(@PathVariable Long userId, @RequestParam(value = "term", required = false) String term, Pageable pageable) {
    	try {	
    		Page<ContactDTO> contacts = contactService.findByUserIdList(userId, term, pageable);   
    		return ResponseEntity.ok(contacts);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }

	@GetMapping("/{contactId}")
    public ResponseEntity<ContactDTO> searchContactById(@PathVariable Long contactId, @PathVariable Long userId) {
        Optional<Contact> contactOptional = contactService.searchContactById(contactId, userId);
        if (contactOptional.isPresent()) {
            ContactDTO contactDTO = convertToDTO(contactOptional.get());
            return ResponseEntity.ok(contactDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<ContactDTO> insertContact(@PathVariable Long userId, @RequestBody ContactDTO contactDTO) {
    	try {
	        Contact contact = convertToEntity(contactDTO);
	        UserData user = new UserData();
	        user.setId(userId);       
	        contact.setUser(user);
	        contact.setEmail(contactDTO.getEmail());
	        contact.setCellphone(contactDTO.getCellphone());
	        Contact insertContact = contactService.saveContact(contact);
	        ContactDTO insertContactDTO = convertToDTO(insertContact);
	        return ResponseEntity.status(HttpStatus.CREATED).body(insertContactDTO);
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    	}
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactDTO> editContact(
            @PathVariable Long userId,
            @PathVariable Long contactId,
            @RequestBody ContactDTO contactDTO
    ) {
        Optional<Contact> contactOptional = contactService.searchContactById(userId, contactId);
        if (contactOptional.isPresent()) {
            Contact contact = convertToEntity(contactDTO);
            contact.setId(contactId);
            contact.setUser(contactOptional.get().getUser());
            Contact editedContact = contactService.saveContact(contact);
            ContactDTO editedContactDTO = convertToDTO(editedContact);
            return ResponseEntity.ok(editedContactDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContacts(@PathVariable Long userId, @PathVariable Long contactId) {
        contactService.deleteContactsByIds(userId, contactId);
        return ResponseEntity.noContent().build();
    }

    private List<ContactDTO> convertToDTO(List<Contact> contacts) {
        return contacts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ContactDTO convertToDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setName(contact.getName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setCellphone(contact.getCellphone());

        if (contact.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            
            addressDTO.setZipCode(contactDTO.getAddress().getZipCode());
            addressDTO.setStreetAddress(contactDTO.getAddress().getStreetAddress());
            addressDTO.setBuildingNumber(contactDTO.getAddress().getBuildingNumber());
            addressDTO.setComplement(contactDTO.getAddress().getComplement());
            addressDTO.setDistrict(contactDTO.getAddress().getDistrict());
            addressDTO.setCity(contactDTO.getAddress().getCity());
            addressDTO.setRegion(contactDTO.getAddress().getRegion());
            addressDTO.setId(contactDTO.getAddress().getId()); 
            
            contactDTO.setAddress(addressDTO);
        }

        return contactDTO;
    }

    private Contact convertToEntity(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setCellphone(contactDTO.getCellphone());

        if (contactDTO.getAddress() != null) {
            Address address = new Address();

            address.setZipCode(contactDTO.getAddress().getZipCode());
            address.setStreetAddress(contactDTO.getAddress().getStreetAddress());
            address.setBuildingNumber(contactDTO.getAddress().getBuildingNumber());
            address.setComplement(contactDTO.getAddress().getComplement());
            address.setDistrict(contactDTO.getAddress().getDistrict());
            address.setCity(contactDTO.getAddress().getCity());
            address.setRegion(contactDTO.getAddress().getRegion());
            address.setId(contactDTO.getAddress().getId()); 
            
            contact.setAddress(address);
        }

        return contact;
    }
}
