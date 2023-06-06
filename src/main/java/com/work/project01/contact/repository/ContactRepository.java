package com.work.project01.contact.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.work.project01.contact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	List<Contact> findByUserId(Long userId);
	
    Optional<Contact> findByIdAndUserId(Long id, Long idUser);
    
    Page<Contact> findByUserId(Long idUser, Pageable pageable);   
    
    @Query("SELECT c FROM Contact c WHERE c.user.id = :userId AND (LOWER(c.name) LIKE %:term% OR LOWER(c.email) LIKE %:term% OR LOWER(c.address) LIKE %:term% OR c.cellphone LIKE %:term%)")
    Page<Contact> findByUserIdAndTerm(@Param("userId") Long userId, @Param("term") String term, Pageable pageable);

}
