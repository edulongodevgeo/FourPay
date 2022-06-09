package br.com.foursys.fourpay.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
public class PolicyController {
	
	@GetMapping
	public String getPolicy() {
		return "String";
	}
}
