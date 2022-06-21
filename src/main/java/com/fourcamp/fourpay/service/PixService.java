package com.fourcamp.fourpay.service;

import com.fourcamp.fourpay.enums.PixKeyType;
import com.fourcamp.fourpay.model.Pix;
import com.fourcamp.fourpay.repository.PixRepository;
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
        List<Pix> pixList = pixRepository.findAll();
        for (Pix item : pixList) {
            if (item.getPixKeyType().equals(pix.getPixKeyType()) && item.getAccount().getId().equals(pix.getAccount().getId())) {
                return null;
            }
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

    public Integer getPixByKeyValueAndKeyType(String keyValue, PixKeyType keyType) {
        List<Pix> pixList = findAll();
        for (Pix item : pixList) {
            if (item.getPixKeyType().equals(keyType) && item.getKeyValue().equals(keyValue)){
                return item.getAccount().getId();
            }
        }
        return null;
    }
}
