package com.api.myapi.controllers;

import com.api.myapi.services.AddressService;
import com.api.myapi.vo.v1.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AddressController {

    @Autowired
    AddressService service;

    @GetMapping
    public List<AddressVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public AddressVO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public AddressVO create(@RequestBody AddressVO address){
        return service.create(address);
    }

    @PutMapping
    public AddressVO update(@RequestBody AddressVO address){
        return service.update(address);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
