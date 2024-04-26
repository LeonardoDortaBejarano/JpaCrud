package com.formacion.jpa.Partner;

import java.util.List;

import com.formacion.jpa.Boat.Boat;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Partner {
    public Partner() {}

    
    
/*     public Partner( String name, String lastname, Integer dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    } */



    @Id
    @GeneratedValue
    private Integer id;

    @Basic
    private String name;
    private String lastname;
    private Integer dni;

    

    @OneToMany(mappedBy ="partner",cascade = CascadeType.ALL )
    private List<Boat> boats;



    public Integer getId() {
        return id;
    }




    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public Integer getDni() {
        return dni;
    }



    public void setDni(Integer dni) {
        this.dni = dni;
    }



    public List<Boat> getBoat() {
        return boats;
    }



    public void setBoat(List<Boat> boats) {
        this.boats = boats;
    }

    public void addOneBoat(Boat boat) {
        this.boats.add(boat);
    }
    
}
