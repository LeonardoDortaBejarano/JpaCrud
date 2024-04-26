package com.formacion.jpa.Boat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/boat")
public class BoatController {

    public BoatController(){};

    @Autowired
    private BoatService boatService;


 
    @PostMapping()
    public ResponseEntity<Boat> createPartner(@RequestBody BoatRequest boat) {
        return boatService.add(boat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boat> getBoat(@PathVariable("id") Integer id) {
        Optional<Boat> partner =  this.boatService.findById(id);
        if (partner.isPresent()) {
            return new ResponseEntity<Boat>(partner.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/not-travel")
    public void getBoatsThatNeverTravel() {
        /* List<Boat> boats =  */this.boatService.getBoatThanNeverLeave();
        /* return  new ResponseEntity<List<Boat>>(HttpStatus.OK); */

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boat> deleteParnter(@PathVariable("id") Integer id) {
        try {
            this.boatService.deleteParnter(id);
            return new ResponseEntity<Boat>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Boat>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Boat> putMethodName(@PathVariable Integer id, @RequestBody Boat partnerRequestData) {
        Optional<Boat> partnert = this.boatService.update(id, partnerRequestData);
        if (partnert.isPresent()) {
            return new ResponseEntity<Boat>(partnert.get(),HttpStatus.OK) ;
        } else {
            return new ResponseEntity<Boat>(HttpStatus.NOT_FOUND) ;
        }
        
    }



    



    

}
