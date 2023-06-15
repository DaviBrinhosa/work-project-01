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
import com.work.project01.configuration.aesutil.AESUtil;
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
    		List<Contact> contacts = contactService.contactByUserId(userId);
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
    public ResponseEntity<String> insertContact(@PathVariable Long userId, @RequestBody ContactDTO contactDTO) {
    	try {
	        Contact contact = convertToEntity(contactDTO);
	        UserData user = new UserData();
	        user.setId(userId);       
	        contact.setUser(user);
	        contact.setEmail(contactDTO.getEmail());
	        contact.setCellphone(contactDTO.getCellphone());
	        contactService.saveContact(contact);
	        
	        String message = "Contato criado com sucesso!";
	        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    	} catch (Exception e) {
    		String invalidMessage = "Não foi possivel criar o contato! Contar o suporte caso persiste o erro";
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(invalidMessage);
    	}
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<String> editContact(@PathVariable Long contactId, @RequestBody ContactDTO contactDTO) {
    	contactService.editContact(contactId, contactDTO);
    	String message = "Contato editado com sucesso!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContacts(@PathVariable Long contactId) {
    	contactService.deleteContacts(contactId);
    	String message = "Contato deletado com sucesso!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
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
            addressDTO.setId(contact.getAddress().getId());
            addressDTO.setZipCode(contact.getAddress().getZipCode());
            addressDTO.setStreetAddress(contact.getAddress().getStreetAddress());
            addressDTO.setBuildingNumber(contact.getAddress().getBuildingNumber());
            addressDTO.setComplement(contact.getAddress().getComplement());
            addressDTO.setDistrict(contact.getAddress().getDistrict());
            addressDTO.setCity(contact.getAddress().getCity());
            addressDTO.setRegion(contact.getAddress().getRegion());

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

            address.setId(contactDTO.getAddress().getId()); 
            address.setZipCode(contactDTO.getAddress().getZipCode());
            address.setStreetAddress(contactDTO.getAddress().getStreetAddress());
            address.setBuildingNumber(contactDTO.getAddress().getBuildingNumber());
            address.setComplement(contactDTO.getAddress().getComplement());
            address.setDistrict(contactDTO.getAddress().getDistrict());
            address.setCity(contactDTO.getAddress().getCity());
            address.setRegion(contactDTO.getAddress().getRegion());
            
            contact.setAddress(address);
        }

        return contact;
    }
}
