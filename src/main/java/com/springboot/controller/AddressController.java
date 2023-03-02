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

    @GetMapping("/getAll")
    public List<Address> findAll()  {
        log.info("GET запрос на /addresses/getAll");
        return addressService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Address findById(@PathVariable("id") Long id) {
        log.info("GET запрос на /addresses/getById{id}");
        return addressService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        addressService.save(address);
        log.info("POST запрос на /addresses/save");
        return ResponseEntity.ok().body(address);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        log.info("PUT запрос на /addresses/update");
        addressService.update(address);
        return ResponseEntity.ok().body(address);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Long id) {
        log.info("DELETE запрос на /addresses/deleteById/{id}");
        addressService.deleteById(id);
    }
}

