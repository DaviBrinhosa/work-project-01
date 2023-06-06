package com.work.project01.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.project01.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
