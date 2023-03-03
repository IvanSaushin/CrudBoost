package com.springboot.controller;

import com.springboot.model.Address;
import com.springboot.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses/")
public class AddressController {

    private static final Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> findAll()  {
        log.info("GET запрос на /addresses/");
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address find(@PathVariable("id") Long id) {
        log.info("GET запрос на /addresses/{id}");
        return addressService.find(id);
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address) {
        addressService.save(address);
        log.info("POST запрос на /addresses/");
        return ResponseEntity.ok().body(address);
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address) {
        log.info("PUT запрос на /addresses/");
        addressService.update(address);
        return ResponseEntity.ok().body(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        log.info("DELETE запрос на /addresses/{id}");
        addressService.delete(id);
    }
}

