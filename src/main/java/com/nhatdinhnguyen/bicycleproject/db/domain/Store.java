package com.nhatdinhnguyen.bicycleproject.db.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer id;
    @Column(name = "store_name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipcode;

    @OneToMany(mappedBy = "store",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Stock> storeStocks;

    @OneToMany(mappedBy = "store",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> storeOrders;

    public Store() {}

    public Store(String name, String phone, String email,
                 String street, String city, String state, String zipcode) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.storeStocks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Stock> getStoreStocks() {
        return storeStocks;
    }

    public void setStoreStocks(List<Stock> storeStocks) {
        this.storeStocks = storeStocks;
    }

    public List<Order> getStoreOrders() {
        return storeOrders;
    }

    public void setStoreOrders(List<Order> storeOrders) {
        this.storeOrders = storeOrders;
    }
}
