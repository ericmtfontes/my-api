package com.api.myapi.services;

import com.api.myapi.handler.ResourceNotFoundException;
import com.api.myapi.mapper.DozerMapper;
import com.api.myapi.models.Person;
import com.api.myapi.repositories.PersonRepository;
import com.api.myapi.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person not found"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        Person entity = DozerMapper.parseObject(person, Person.class);

        PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVO update (PersonVO person){

        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException(("Person not found")));

        entity.setName(person.getName());
        entity.setSex(person.getSex());
        entity.setHeight(person.getHeight());
        entity.getAddress().setId(person.getAddress().getId());

        PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public void delete(Long id){
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Person not found")));

        repository.delete(entity);
    }
}
