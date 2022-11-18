package com.api.myapi.services;

import com.api.myapi.handler.ResourceNotFoundException;
import com.api.myapi.models.Person;
import com.api.myapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person not found"));
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update (Person person){

        Person p = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException(("Person not found")));

        p.setName(person.getName());
        p.setSex(person.getSex());
        p.setHeight(person.getHeight());
        p.getAddress().setRoad(person.getAddress().getRoad());
        p.getAddress().setNumber(person.getAddress().getNumber());
        p.getAddress().setDistrict(person.getAddress().getDistrict());
        p.getAddress().setCity(person.getAddress().getCity());
        p.getAddress().setCountry(person.getAddress().getCountry());

        return repository.save(p);
    }
}
