package com.workproject01.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workproject01.backend.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	

}
