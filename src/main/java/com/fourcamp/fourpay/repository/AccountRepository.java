package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//Utilizamos o jpa repository para ter acesso a vários metodos já prontos
//Quando extendemos com o jpa repository nao precisamos anotar o @repository
//Porém por questão de aprendizado vamos colocar o @repository para transações em base de dados

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
}
