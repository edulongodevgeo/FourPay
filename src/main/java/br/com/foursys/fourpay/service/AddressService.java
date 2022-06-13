package br.com.foursys.fourpay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourpay.model.Address;
import br.com.foursys.fourpay.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public Address save(Address address) {
		return addressRepository.save(address);
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address updateById(Integer id, Address address) {
		List<Address> listAddress = addressRepository.findAll();
		for (Address item : listAddress) {
			if (item.getId().equals(id)) {
				address.setId(id);
				return addressRepository.save(address);
			}
		}
		return null;
	}
}