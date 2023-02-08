package com.springboot.service.impl;

import com.springboot.model.Adress;
import com.springboot.repository.AdressRepository;
import com.springboot.service.AdressService;

import java.util.List;

public class AdressServiceImpl implements AdressService {

    private AdressRepository adressRepository;

    @Override
    public void saveAdress(Adress adress) {

    }

    @Override
    public List<Adress> getAllAdresses() {
         return adressRepository.findAll();
    }

    @Override
    public Adress getAdressById(Long id) {
        return null;
    }

    @Override
    public void update(Adress adress) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
