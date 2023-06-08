package com.work.project01.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public void deleteContactsByIds(Long contactId, Long userId) {
        Optional<Contact> contactOptional = contactRepository.findByIdAndUserId(contactId, userId);
        contactOptional.ifPresent(contactRepository::delete);
    }
}
