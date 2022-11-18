package com.api.myapi.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String sex; //M OR F
    @Column
    private Float height;
    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;

    public Person(){
    }

    public Person(Long id, String name, String sex, Float height) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
