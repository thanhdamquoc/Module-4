package com.codegym.simplecustomermanagementspringboot.repository;

import com.codegym.simplecustomermanagementspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
