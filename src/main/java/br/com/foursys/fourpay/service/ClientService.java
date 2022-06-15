package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Client;
import br.com.foursys.fourpay.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
