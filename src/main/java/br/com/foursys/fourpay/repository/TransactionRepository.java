package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {


}
