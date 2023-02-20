package com.springboot.controller;

import com.springboot.model.Address;
import com.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/getAllAddresses")
    public List<Address> getAllAddresses()  {
        return addressService.getAllAddresses();
    }

    @GetMapping("/getAddress/{id}")
    public Address getAddress(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        addressService.saveAddress(address);
        return ResponseEntity.ok().body(address);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        addressService.update(address);
        return ResponseEntity.ok().body(address);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.deleteById(id);
    }
}

