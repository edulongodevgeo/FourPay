package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Pix;
import br.com.foursys.fourpay.repository.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PixService {
    @Autowired
    PixRepository pixRepository;

    public Pix save(Pix pix) {
        if (pix.getPixKeyType() == null) {
            return null;
        }
        return pixRepository.save(pix);
    }

    public List<Pix> findAll() {
        return pixRepository.findAll();
    }

    public Pix getPixById(Integer id) {
        List<Pix> pixList = findAll();
        for (Pix item : pixList) {
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }
}
