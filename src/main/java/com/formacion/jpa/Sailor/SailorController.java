package com.formacion.jpa.Sailor;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/sailor")
public class SailorController {
    public SailorController(){}

    @Autowired
    private SailorService sailorService;
    private Object tripRepository;


    @PostMapping()
    public ResponseEntity<Sailor> createSailor(@RequestBody Sailor sailor) {
        return ResponseEntity.ok(sailorService.add(sailor));
    }


    
    



    @GetMapping("/{id}")
    public ResponseEntity<Sailor> getSailor(@PathVariable("id") Integer id) {
        Optional<Sailor> partner =  this.sailorService.findById(id);
        if (partner.isPresent()) {
            return new ResponseEntity<Sailor>(partner.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sailor> deleteParnter(@PathVariable("id") Integer id) {
        try {
            this.sailorService.deleteParnter(id);
            return new ResponseEntity<Sailor>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Sailor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Sailor> putMethodName(@PathVariable Integer id, @RequestBody Sailor partnerRequestData) {
        Optional<Sailor> partnert = this.sailorService.update(id, partnerRequestData);
        if (partnert.isPresent()) {
            return new ResponseEntity<Sailor>(partnert.get(),HttpStatus.OK) ;
        } else {
            return new ResponseEntity<Sailor>(HttpStatus.NOT_FOUND) ;
        }
        
    }




}
