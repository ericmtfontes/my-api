package com.api.myapi.vo.v1;

import java.io.Serializable;

public class AddressVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String road;
    private Integer number;
    private String district;
    private String city;
    private String country;

    public AddressVO(){
    }

    public AddressVO(Long id, String road, Integer number, String district, String city, String country) {
        this.id = id;
        this.road = road;
        this.number = number;
        this.district = district;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

