package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
