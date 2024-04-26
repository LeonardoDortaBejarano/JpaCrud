package com.formacion.jpa.Sailor;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.formacion.jpa.Trip.Trip;

@Entity
public class Sailor {
    public Sailor(){};


    public Sailor(Integer id, Integer dni, String name, String lastName, List<Trip> trips) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.trips = trips;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private Integer dni;
    @Basic
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "sailor")
    private List<Trip> trips;

    public Integer getId() {
        return id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

/*     public List<Trip> getTrips() {
        return trips;
    } */



}
