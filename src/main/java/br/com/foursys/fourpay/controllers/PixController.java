package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.PixDTO;
import br.com.foursys.fourpay.model.Pix;
import br.com.foursys.fourpay.service.PixService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/pix")
public class PixController {
	@Autowired
	PixService pixService;
	@Autowired
	AccountController accountController;
	
	@GetMapping
	public List<Pix> getPix() {
		return pixService.findAll();
	}

	@GetMapping("/{id}")
	public Pix getPixById(@PathVariable Integer id) {
		return pixService.getPixById(id);
	}

	@PostMapping
	public Pix createNewPix(@RequestBody @Valid PixDTO pixDTO) {
		Pix pix = new Pix();
		BeanUtils.copyProperties(pixDTO, pix);
		pix.setIsActive(true);
		//pix.setAccount(accountController.getAccountById(pixDTO.getAccountId()));
		return pixService.save(pix);
	}

	@PutMapping("/{id}")
	public Pix updatePixStatus(@PathVariable Integer id, @RequestBody @Valid PixDTO pixDto){
		Pix pix = getPixById(id);
		if(pix == null) {
			return null;
		}
		BeanUtils.copyProperties(pixDto,pix);
		return pixService.save(pix);
	}
}
