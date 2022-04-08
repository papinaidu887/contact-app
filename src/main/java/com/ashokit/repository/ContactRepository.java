package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	

}
