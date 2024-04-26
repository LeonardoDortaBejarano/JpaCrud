package com.formacion.jpa.Boat;

public class BoatRequest {
    
    private Integer spotNumber;
    private Integer quota;
    private String registration;
    private Integer partnerid;

    public BoatRequest(){};

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
    public Integer getPartnerid() {
        return partnerid;
    }
    public void setPartnerid(Integer partnerid) {
        this.partnerid = partnerid;
    }

}
