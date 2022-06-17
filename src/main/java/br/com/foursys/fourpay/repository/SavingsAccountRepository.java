package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {

}
