package com.fourcamp.fourpay.controllers;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourcamp.fourpay.dto.AddressDTO;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.*;
import com.fourcamp.fourpay.model.Address;
import com.fourcamp.fourpay.service.AddressService;

@RestController
@RequestMapping("/address")
//@Tag(name = "API REST Address")
@CrossOrigin(origins = "*")
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping
	//@Operation(summary = "Salva o endereço durante a criação do cliente")
	public Address saveAddressFromClientCreation(Address address) {
		return addressService.save(address);
	}

	@PostMapping("/create")
	//@Operation(summary = "Salva um endereço")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.save(address);
	}

	@GetMapping
	//@Operation(summary = "Retorna todos os endereços")
	public List<Address> findAddress() {
		return addressService.findAll();
	}

	@PutMapping("/{id}")
	//@Operation(summary = "Atualiza o endereço pelo Id dele")
	public Address updateAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDto) {
		Address address = new Address();
		BeanUtils.copyProperties(addressDto, address);
		return addressService.updateById(id, address);
	}
}