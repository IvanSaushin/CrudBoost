package com.springboot.controller;

import com.springboot.model.Address;
import com.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/getAll")
    public List<Address> findAll()  {
        return addressService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Address findById(@PathVariable("id") Long id) {
        return addressService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        addressService.save(address);
        return ResponseEntity.ok().body(address);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        addressService.update(address);
        return ResponseEntity.ok().body(address);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.deleteById(id);
    }
}

