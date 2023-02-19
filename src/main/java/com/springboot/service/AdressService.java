package com.springboot.service;

import com.springboot.model.Adress;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface AdressService {

    void saveAdress(Adress adress);
    List<Adress> getAllAdresses();
    Adress getAdressById(Long id);
    void update(Adress adress);
    void deleteById(Long id);

}
