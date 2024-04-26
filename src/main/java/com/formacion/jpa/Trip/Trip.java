package com.formacion.jpa.Trip;

import java.sql.Date;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

import com.formacion.jpa.Boat.Boat;
import com.formacion.jpa.Sailor.Sailor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Trip {
    public Trip(){}

    @Id
    @GeneratedValue
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Time hour;


    private String destination;

    @ManyToOne()
    private Boat boat;

    @ManyToOne()
    private Sailor sailor;

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Sailor getSailor() {
        return sailor;
    }

    public void setSailor(Sailor sailor) {
        this.sailor = sailor;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }



    


}
