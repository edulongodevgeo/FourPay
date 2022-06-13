package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.enums.model.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {
}
