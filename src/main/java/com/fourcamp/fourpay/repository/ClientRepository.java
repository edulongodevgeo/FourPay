package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
