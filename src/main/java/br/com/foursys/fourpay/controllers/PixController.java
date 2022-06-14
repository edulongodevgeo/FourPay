package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.PixDTO;
import br.com.foursys.fourpay.model.Pix;
import br.com.foursys.fourpay.service.AccountService;
import br.com.foursys.fourpay.service.PixService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/pix")
public class PixController {
	@Autowired
	PixService pixService;
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public ResponseEntity<List<Pix>> getPix() {
		return ResponseEntity.status(HttpStatus.OK).body(pixService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pix> getPixById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(pixService.getPixById(id));
	}

	@PostMapping
	public ResponseEntity<Pix> createNewPix(@RequestBody @Valid PixDTO pixDTO) {
		Pix pix = new Pix();
		BeanUtils.copyProperties(pixDTO, pix);
		pix.setIsActive(true);
		pix.setAccount(accountService.findById(pixDTO.getAccountId()).get());
		return ResponseEntity.status(HttpStatus.CREATED).body(pixService.save(pix));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pix> updatePixStatus(@PathVariable Integer id, @RequestBody @Valid PixDTO pixDto){
		Pix pix = pixService.getPixById(id);
		if(pix == null) {
			return null;
		}
		BeanUtils.copyProperties(pixDto,pix);
		return ResponseEntity.status(HttpStatus.OK).body(pixService.save(pix));
	}
}
