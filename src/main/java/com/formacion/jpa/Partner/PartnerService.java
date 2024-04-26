package com.formacion.jpa.Partner;

import java.util.Optional;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.formacion.jpa.Boat.Boat;
import com.formacion.jpa.Boat.BoatRepository;
import com.formacion.jpa.Sailor.SailorRepository;

@Service
public class PartnerService {
    public PartnerService(){}

    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private BoatRepository boatRepository;


    public Partner add(Partner partner){
        return partnerRepository.save(partner);
    }


    public Optional<Partner> findById(Integer id) {
        return partnerRepository.findById((long)id);
    }


    public void deleteParnter(Integer id) {
         partnerRepository.deleteById((long)id);
    }


    public Optional<Partner> update(Integer id,Partner partnerRequestData){
        Optional<Partner> partnerToUpdate = partnerRepository.findById((long)id);
        if (partnerToUpdate.isPresent()) {
            partnerToUpdate.get().setDni(partnerRequestData.getDni());
            partnerToUpdate.get().setLastname(partnerRequestData.getLastname());
            partnerToUpdate.get().setName(partnerRequestData.getName());
            partnerToUpdate.get().setBoat(partnerRequestData.getBoat());
            partnerRepository.save(partnerToUpdate.get());
        } 
        return partnerToUpdate;

    }


    public ResponseEntity<Boat> addBoatToPartner(Integer partnerId,Boat boat) {
        Optional<Partner> partner = this.partnerRepository.findById((long)partnerId);
        if (partner.isPresent()) {

            partner.get().addOneBoat(boat);
            Boat boatRespondBody =  this.boatRepository.save(boat);
            return new ResponseEntity<Boat> (boatRespondBody, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boat> (HttpStatus.NOT_FOUND);
        }

    }
}
