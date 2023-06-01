package com.work.project01.userdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.project01.userdata.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
	
}
