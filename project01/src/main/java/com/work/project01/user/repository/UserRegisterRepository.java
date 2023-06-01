package com.work.project01.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.project01.user.entity.UserRegister;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Long> {
	
}
