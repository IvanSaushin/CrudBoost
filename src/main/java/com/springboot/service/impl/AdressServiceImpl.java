package com.springboot.service.impl;

import com.springboot.Application;
import com.springboot.model.Adress;
import com.springboot.repository.AdressRepository;
import com.springboot.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {

    private AdressRepository adressRepository;

    @Autowired
    public void setAdressService (AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public void saveAdress(Adress adress) {
        adressRepository.save(adress);
    }

    @Override
    public List<Adress> getAllAdresses() {
         return adressRepository.findAll();
    }

    @Override
    public Adress getAdressById(Long id) {
        return adressRepository.findById(id).get();
    }

    @Override
    public void update(Adress adress) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @EventListener (ApplicationReadyEvent.class)
    public void test () {
        System.out.println("test");
        String country = "Russia";
        Adress adress = new Adress("Russia", "Astrakhan", "Sverdlova", "5/1", "2", LocalDate.now(), 0L);
        adressRepository.save(adress);
        System.out.println(adress);
    }



}
