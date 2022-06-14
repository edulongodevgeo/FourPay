package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
