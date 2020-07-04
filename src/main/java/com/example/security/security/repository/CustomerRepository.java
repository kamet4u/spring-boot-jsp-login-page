package com.example.security.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findById(long id);

	Customer findByFirstName(String firstName);

	Customer findByLastName(String lastName);

	Customer findByEmail(String email);
}
