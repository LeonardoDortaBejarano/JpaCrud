package com.formacion.jpa.Sailor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.jpa.Trip.TripRepository;

@Service
public class SailorService {
    @Autowired
    private SailorRepository sailorRepository;
    private TripRepository tripRepository;



    public Sailor add(Sailor sailor){
        return this.sailorRepository.save(sailor);
    }


    public Optional<Sailor> findById(Integer id) {
        return this.sailorRepository.findById(id);
    }


    public void deleteParnter(Integer id) {
         this.sailorRepository.deleteById(id);
    }




    public Optional<Sailor> update(Integer id,Sailor sailorRequestData){
        Optional<Sailor> sailorToUpdate = this.sailorRepository.findById(id);
        if (sailorToUpdate.isPresent()) {
            sailorToUpdate.get().setDni(sailorRequestData.getDni());
            sailorToUpdate.get().setLastName(sailorRequestData.getLastName());
            sailorToUpdate.get().setName(sailorRequestData.getName());
        } 
        return sailorToUpdate;

    }
}
