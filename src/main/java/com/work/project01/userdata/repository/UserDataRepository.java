package com.work.project01.userdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.work.project01.userdata.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
	
	UserData findByEmail(String email);
	
	@Query("SELECT c FROM UserData c WHERE LOWER(c.email) = LOWER(:email)")
	UserData validateEmail(@Param("email") String email);
		
}
