package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.enums.model.Client;
import br.com.foursys.fourpay.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
    public Optional<Client> getClientId(Integer id){
        return clientRepository.findById(id);
    }
    public Client addClient(Client client){
        return clientRepository.save(client);
    }
    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }
    public Client updateClient(Integer id, Client client){
        client.setId(id);
        return clientRepository.save(client);
    }

}
