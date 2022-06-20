package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.RegisterDto;
import br.com.foursys.fourpay.enums.ClientType;
import br.com.foursys.fourpay.model.Address;
import br.com.foursys.fourpay.model.CheckingsAccount;
import br.com.foursys.fourpay.model.Client;
import br.com.foursys.fourpay.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    AccountController accountController;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable Integer id) {
        return clientService.getClientId(id);
    }

    @Autowired
    AddressController addressController;

    @PostMapping
    public CheckingsAccount addClient(@RequestBody RegisterDto registerDto) {

        Client client = new Client();
        Address adress = new Address();
        BeanUtils.copyProperties(registerDto, client);
        BeanUtils.copyProperties(registerDto, adress);
        client.setClientType(determineClientType(registerDto.getMonthlyIncome()));
        client.setAddress(adress);
        addressController.saveAddressFromClientCreation(adress);
        clientService.addClient(client);
        return accountController.createCheckingsAccountFromClientCreation(client);
    }

    private ClientType determineClientType(Double monthlyIncome) {
        if (monthlyIncome < 3000) {
            return ClientType.COMUM;
        } else if (monthlyIncome >= 3000 && monthlyIncome < 7000) {
            return ClientType.SUPER;
        } else {
            return ClientType.PREMIUM;
        }
    }

    @DeleteMapping("/{id}")
    public String deletClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return "Produto com o id: " + id + " deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Integer id) {
        client.setClientType(determineClientType(client.getMonthlyIncome()));
        return clientService.updateClient(id, client);
    }

    public Client getClientByEmailAndPassword(String email, String password) {
        return clientService.getClientByEmailAndPassword(email, password);
    }

    public String forgotPassword(String email) {
        return clientService.getClientByEmail(email);
    }
}
