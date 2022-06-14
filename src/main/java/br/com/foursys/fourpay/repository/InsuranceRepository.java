package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}