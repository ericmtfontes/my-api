package com.api.myapi.services;

import com.api.myapi.handler.ResourceNotFoundException;
import com.api.myapi.mapper.DozerMapper;
import com.api.myapi.models.Address;
import com.api.myapi.repositories.AddressRepository;
import com.api.myapi.vo.v1.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public List<AddressVO> findAll(){
        return DozerMapper.parseListObjects(repository.findAll(), AddressVO.class);
    }

    public AddressVO findById(Long id){
        Address entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address not found"));

        return DozerMapper.parseObject(entity, AddressVO.class);
    }

    public AddressVO create(AddressVO address){
        Address entity = DozerMapper.parseObject(address, Address.class);

        return DozerMapper.parseObject(repository.save(entity), AddressVO.class);
    }

    public AddressVO update(AddressVO address){
        Address entity = repository.findById(address.getId()).orElseThrow(()-> new ResourceNotFoundException("Address not found"));

        entity.setRoad(address.getRoad());
        entity.setNumber(address.getNumber());
        entity.setDistrict(address.getDistrict());
        entity.setCity(address.getCity());
        entity.setCountry(address.getCountry());

        return DozerMapper.parseObject(repository.save(entity), AddressVO.class);
    }

    public void delete(Long id){
        Address entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address not found"));

        repository.delete(entity);
    }
}
