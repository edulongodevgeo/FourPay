package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.LoginDTO;
import br.com.foursys.fourpay.dto.RegisterDto;
import br.com.foursys.fourpay.model.Client;
import org.apache.coyote.Response;
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
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
        Client client = clientController.getClientByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (client != null) {
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto) {
        Client client = clientController.addClient(registerDto);
        if (client != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Informações invalidas ou cpf já cadastrado");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Object> forgotPassword(@RequestBody LoginDTO loginDTO) {
        String password = clientController.forgotPassword(loginDTO.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(password);
    }
}
