package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PolicyRepository extends JpaRepository<Policy, UUID> {



}
