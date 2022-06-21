package com.fourcamp.fourpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourcamp.fourpay.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}