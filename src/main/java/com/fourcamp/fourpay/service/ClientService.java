package com.fourcamp.fourpay.service;

import com.fourcamp.fourpay.model.Client;
import com.fourcamp.fourpay.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientId(Integer id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client addClient(Client client) {
        List<Client> clients = clientRepository.findAll();
        for (Client item : clients) {
            if (item.getCpf().equals(client.getCpf())) {
                return null;
            }
        }
        return clientRepository.save(client);
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Integer id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    public Client getClientByEmailAndPassword(String email, String password) {
        List<Client> clientList = getAllClient();
        for (Client client : clientList) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null;
    }

    public String getClientByEmail(String email) {
        List<Client> clientList = getAllClient();
        for (Client client : clientList) {
            if (client.getEmail().equals(email)) {
                return client.getPassword();
            }
        }
        return null;
    }
}
