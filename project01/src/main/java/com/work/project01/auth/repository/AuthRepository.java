package com.work.project01.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.project01.auth.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Long> {

}
