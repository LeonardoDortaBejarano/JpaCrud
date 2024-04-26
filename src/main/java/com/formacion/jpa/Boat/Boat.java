package com.formacion.jpa.Boat;

import java.util.List;

import com.formacion.jpa.Partner.Partner;
import com.formacion.jpa.Trip.Trip;

import jakarta.annotation.Generated;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Boat {

    public Boat(){};

    public Boat(BoatRequest boatData){
        this.spotNumber = boatData.getSpotNumber();
        this.quota = boatData.getQuota();
        this.registration = boatData.getRegistration();
    };

    @Id
    @GeneratedValue
    private Integer id;

    
    
    @Column(name = "spot_number")
    private Integer spotNumber;
    @Basic
    private Integer quota;
    private String registration;

    @ManyToOne
    private Partner partner;

    @OneToMany(mappedBy = "boat", cascade = CascadeType.ALL)
    private List<Trip> Trips;

 

    public Integer getId() {
        return id;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public List<Trip> getTrips() {
        return Trips;
    }

    public void setTrips(List<Trip> trips) {
        Trips = trips;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
