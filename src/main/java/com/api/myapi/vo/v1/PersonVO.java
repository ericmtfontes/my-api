package com.api.myapi.vo.v1;

import java.io.Serializable;

public class PersonVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String sex; //M OR F
    private Float height;
    private AddressVO address;

    public PersonVO(){
    }

    public PersonVO(Long id, String name, String sex, Float height) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public AddressVO getAddress() {
        return address;
    }

    public void setAddress(AddressVO address) {
        this.address = address;
    }
}

