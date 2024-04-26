package com.formacion.jpa.Boat;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.formacion.jpa.Partner.Partner;
import com.formacion.jpa.Partner.PartnerRepository;
/* import com.formacion.jpa.Trip.QTrip; */
/* import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory; */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class BoatService {
    public BoatService(){}

    @Autowired
    private BoatRepository boatRepository;
    @Autowired
    private PartnerRepository partnerRepository;


    public ResponseEntity<Boat> add(BoatRequest boatData){
        Optional<Partner> partner =  partnerRepository.findById((long) boatData.getPartnerid());
        if (partner.isPresent()) {
            Boat boat = new Boat(boatData);
            boat.setPartner(partner.get());
            boat = boatRepository.save(boat);
            return new ResponseEntity<Boat> (boat,HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }


    public Optional<Boat> findById(Integer id) {
        return boatRepository.findById((long)id);
    }


    public void deleteParnter(Integer id) {
        boatRepository.deleteById((long)id);
    }


    public Optional<Boat> update(Integer id,Boat boatRequestData){
        Optional<Boat> boatToUpdate = boatRepository.findById((long)id);
        if (boatToUpdate.isPresent()) {
            boatToUpdate.get().setPartner(boatRequestData.getPartner());
            boatToUpdate.get().setQuota(boatRequestData.getQuota());
            boatToUpdate.get().setRegistration(boatRequestData.getRegistration());
            boatRepository.save(boatToUpdate.get());
        } 
        return boatToUpdate;

    }

    public void getBoatThanNeverLeave() {
        /* EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("com.baeldung.querydsl.intro");
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory queryFactory = new JPAQueryFactory(JPQLTemplates.DEFAULT, em);

        QBoat boat= QBoat.boat;
        QTrip trip= QTrip.trip;

        List<Boat> boatsResult = queryFactory.selectFrom(boat)
                        .where(boat.id.notIn(queryFactory.select(trip.boat.id).from(trip)))
                        .fetch();

        return boatsResult;

        List<Boat> c = queryFactory.selectFrom(boat)
        .fetch(); */
            


    }


    


}
