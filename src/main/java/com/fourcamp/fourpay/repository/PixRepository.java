package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.Pix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixRepository extends JpaRepository<Pix, Integer> {
}
