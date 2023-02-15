package com.springboot.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "adresses")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "country")
    private String country;

    @Column (name = "city")
    private String city;

    @Column (name = "street")
    private String street;

    @Column (name = "house")
    private String house;

    @Column (name = "apartment")
    private String apartment;

    @Column (name = "date_start")
    private LocalDate date_start;

    @Column (name = "user_id")
    private Long user_id;

    public Adress () {}

    public Adress (Long id, String country, String city, String street, String house, String apartment, LocalDate date_start, Long user_id) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.date_start = date_start;
        this.user_id = user_id;
    }

    public Adress (String country, String city, String street, String house, String apartment, LocalDate date_start, Long user_id) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.date_start = date_start;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Adress" + id + ", country: " + getCountry() + ", city: " + getCity() +
                ", street: " + getStreet() + ", house: " + getHouse() + ", appartment: " + getApartment() +
                ", date_start: " + getDate_start() + ", user_id: " + getUser_id() ;
    }
}