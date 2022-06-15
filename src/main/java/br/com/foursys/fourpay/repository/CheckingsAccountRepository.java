package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.CheckingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingsAccountRepository extends JpaRepository<CheckingsAccount, Integer> {

}

