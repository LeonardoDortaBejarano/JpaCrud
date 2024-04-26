package com.formacion.jpa.Trip;

import java.sql.Date;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

public class TripRequest {

    public TripRequest(){};
    
    @DateTimeFormat(pattern = "HH:mm:ss dd/MM/yyyy")
    private Date date;
    private Time hour;


    private String destination;
    private Integer boatId;
    private Integer sailorId;

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
    public Integer getBoatId() {
        return boatId;
    }
    public void setBoatId(Integer boatId) {
        this.boatId = boatId;
    }
    public Integer getSailorId() {
        return sailorId;
    }
    public void setSailorId(Integer sailorId) {
        this.sailorId = sailorId;
    }
    public Time getHour() {
        return this.hour;
    }

    public void setHour(Time time) {
        this.hour = time;
    }

    



}
