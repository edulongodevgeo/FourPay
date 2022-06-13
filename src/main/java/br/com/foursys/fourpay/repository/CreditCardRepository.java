package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.enums.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCard, Integer> {
}
