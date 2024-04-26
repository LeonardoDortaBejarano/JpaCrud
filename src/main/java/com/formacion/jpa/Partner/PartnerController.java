package com.formacion.jpa.Partner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.jpa.Boat.Boat;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/partner")
public class PartnerController {

    public PartnerController(){};

    @Autowired
    private PartnerService partnerService;


 
    @PostMapping()
    public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
        return ResponseEntity.ok(partnerService.add(partner));
    }

    @PostMapping("/{id}/boat")
    public ResponseEntity<Boat> createPartnerBoat(@PathVariable("id") Integer partnerId,@RequestBody Boat boat) {
        return partnerService.addBoatToPartner(partnerId,boat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartner(@PathVariable("id") Integer id) {
        Optional<Partner> partner =  this.partnerService.findById(id);
        if (partner.isPresent()) {
            return new ResponseEntity<Partner>(partner.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Partner> deleteParnter(@PathVariable("id") Integer id) {
        try {
            this.partnerService.deleteParnter(id);
            return new ResponseEntity<Partner>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Partner>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Partner> putMethodName(@PathVariable Integer id, @RequestBody Partner partnerRequestData) {
        Optional<Partner> partnert = this.partnerService.update(id, partnerRequestData);
        if (partnert.isPresent()) {
            return new ResponseEntity<Partner>(partnert.get(),HttpStatus.OK) ;
        } else {
            return new ResponseEntity<Partner>(HttpStatus.NOT_FOUND) ;
        }
        
    }



    



    

}
