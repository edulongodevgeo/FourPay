package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PolicyRepository extends JpaRepository<Policy, UUID> {



}
