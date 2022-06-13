package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.model.Client;
import br.com.foursys.fourpay.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/id/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAllClient();
    }
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable Integer id){
        return clientService.getClientId(id);
    }
    @PostMapping
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }
    @DeleteMapping("/{id}")
    public String deletClient(@PathVariable Integer id){
        clientService.deleteClient(id);
        return "Produto com o id: " + id + " deletado com sucesso!";
    }
    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Integer id){
        return clientService.updateClient(id, client);
    }
}
