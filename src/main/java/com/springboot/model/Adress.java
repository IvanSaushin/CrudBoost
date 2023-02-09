package com.springboot.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "county")
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

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public String getApartment() {
        return apartment;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
