package com.formacion.jpa.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.formacion.jpa.Boat.Boat;
import com.formacion.jpa.Sailor.Sailor;
import com.formacion.jpa.Boat.BoatRepository;
import com.formacion.jpa.Sailor.SailorRepository;
/* import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory; */

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TripService {
    public TripService(){}

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private SailorRepository sailorRepository;
    @Autowired
    private BoatRepository boatRepository;
    @Autowired
    private EntityManager em;
    

    public Optional<Trip> get(Integer id) {
        return tripRepository.findById(id);
    };

    public ResponseEntity<Trip> add(TripRequest tripRequest ){
        Optional<Boat> boat = boatRepository.findById((long) tripRequest.getBoatId());
        Optional<Sailor> sailor = sailorRepository.findById( tripRequest.getSailorId());

        if (boat.isPresent() && sailor.isPresent()) {
            Trip trip =  new Trip();
            trip.setBoat(boat.get());
            trip.setDate(tripRequest.getDate());
            trip.setHour(tripRequest.getHour());
            trip.setDestination(tripRequest.getDestination());
            trip.setSailor(sailor.get());
            return new ResponseEntity<Trip>(this.tripRepository.save(trip),HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    };
    

    public List<String> getMostExpertiseSailor() {
        return this.tripRepository.findSailorsWithMoreExpertice();
   }

    public Optional<Trip> update(Integer id, Trip tripRequestData){
        Optional<Trip> tripToUpdate = this.tripRepository.findById(id);
        if (tripToUpdate.isPresent()) {
            tripToUpdate.get().setBoat(tripRequestData.getBoat());
            tripToUpdate.get().setDate(tripRequestData.getDate());
            tripToUpdate.get().setDestination(tripRequestData.getDestination());
            tripToUpdate.get().setHour(tripRequestData.getHour());
            tripToUpdate.get().setSailor(tripRequestData.getSailor());

            tripRepository.save(tripToUpdate.get());
        } 
        return tripToUpdate;

    }

    public void remove(Integer id){
        this.tripRepository.deleteById(id);
    };

    public List<Object[]> getTripGroupByDate() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Trip> tripRoot = cq.from(Trip.class);
        cq.multiselect(tripRoot.get("date"), cb.count(tripRoot));
        cq.groupBy(tripRoot.get("date"));
        return em.createQuery(cq).getResultList();
    }


   
}
