package com.work.project01.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.project01.address.entity.Address;
import com.work.project01.contact.dto.ContactDTO;
import com.work.project01.contact.entity.Contact;
import com.work.project01.contact.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private final ContactRepository contactRepository;
	
	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

    @Transactional
    public List<Contact> contactByUserId(Long userId) {
        return contactRepository.findByUserId(userId);
    }
    
	@Transactional(readOnly = true)
    public Page<ContactDTO> findByUserIdList(Long userId, String term, Pageable pageable) {
		if (term != null && !term.isEmpty()) {
			Page<Contact> result = contactRepository.findByUserIdAndTerm(userId, term, pageable);
			return result.map(x -> new ContactDTO(x));
		} else {
			Page<Contact> result = contactRepository.findByUserId(userId, pageable);
			return result.map(x -> new ContactDTO(x));
		}
    }
	
    @Transactional
    public Optional<Contact> searchContactById(Long contactId, Long userId) {
        return contactRepository.findByIdAndUserId(contactId, userId);
    }

    @Transactional
    public ContactDTO editContact(Long contactId, ContactDTO contactDTO) {
    	Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado, contar o suporte caso persiste o erro"));
    	 contact.setName(contactDTO.getName());
         contact.setEmail(contactDTO.getEmail());
         contact.setCellphone(contactDTO.getCellphone());

         if (contactDTO.getAddress() != null) {
             Address address = contact.getAddress();

             address.setZipCode(contactDTO.getAddress().getZipCode());
             address.setStreetAddress(contactDTO.getAddress().getStreetAddress());
             address.setBuildingNumber(contactDTO.getAddress().getBuildingNumber());
             address.setComplement(contactDTO.getAddress().getComplement());
             address.setDistrict(contactDTO.getAddress().getDistrict());
             address.setCity(contactDTO.getAddress().getCity());
             address.setRegion(contactDTO.getAddress().getRegion());
         }
    	
    	Contact updatedContact = contactRepository.save(contact);
        return new ContactDTO(updatedContact);
    }

    @Transactional
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public void deleteContacts(Long contactId) {
    	Contact contact = contactRepository.findById(contactId)
    			.orElseThrow(() -> new IllegalArgumentException("Contato não encontrado, contar o suporte caso persiste o erro"));
    	contactRepository.delete(contact);
    }
}
