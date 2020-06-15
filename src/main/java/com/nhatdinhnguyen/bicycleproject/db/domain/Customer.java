package com.nhatdinhnguyen.bicycleproject.db.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name")),
            @AttributeOverride(name = "phone", column = @Column(name = "phone")),
            @AttributeOverride(name = "email", column = @Column(name = "email")),
    })
    private Person person;

    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private final List<Order> orders = new ArrayList<>();

    public Customer() {}

    public Customer(Person person, String street, String city, String state, String zipCode) {
        this.person = person;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Customer(String state) {
        this.person = null;
        this.street = null;
        this.city = null;
        this.state = state;
        this.zipCode = null;
    }

    public Customer(Person person) {
        this.person = person;
        this.street = null;
        this.city = null;
        this.state = null;
        this.zipCode = null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", person=" + person +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
