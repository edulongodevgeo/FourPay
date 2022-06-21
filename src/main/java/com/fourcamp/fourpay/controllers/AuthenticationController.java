package com.fourcamp.fourpay.controllers;

import com.fourcamp.fourpay.dto.LoginDTO;
import com.fourcamp.fourpay.dto.RegisterDto;
import com.fourcamp.fourpay.model.CheckingsAccount;
import com.fourcamp.fourpay.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    ClientController clientController;

    @PostMapping("/login")
    public ResponseEntity<Client> login(@RequestBody LoginDTO loginDTO) {
        Client client = clientController.getClientByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (client != null) {
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PostMapping("/register")
    public ResponseEntity<CheckingsAccount> register(@RequestBody RegisterDto registerDto) {
        CheckingsAccount client = clientController.addClient(registerDto);
        if (client != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody LoginDTO loginDTO) {
        String password = clientController.forgotPassword(loginDTO.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(password);
    }
}
