package com.formacion.jpa.Trip;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    public TripController(){}
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable("id") Integer id) {
        Optional<Trip> trip =  this.tripService.get(id);
        if (trip.isPresent()) {
            return new ResponseEntity<Trip>(trip.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    

    @PostMapping()
    public ResponseEntity<Trip> postMethodName(@RequestBody TripRequest tripRequest) {
        
        return this.tripService.add(tripRequest);
    }

    @GetMapping("/most-experience-sailors")
    public ResponseEntity<List<String>> getMostExpertiseSailor(Integer id) {
        List <String>response =this.tripService.getMostExpertiseSailor();
        return new ResponseEntity<List<String>>(response,HttpStatus.ACCEPTED);
        
   }

   @GetMapping("/quantity-by-date")
   public ResponseEntity<List<Object[]>> getTripsByDate(Integer id) {
       List <Object[]>response =this.tripService.getTripGroupByDate();
       return new ResponseEntity<List<Object[]>>(response,HttpStatus.ACCEPTED);
       
  }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> putMethodName(@PathVariable Integer id, @RequestBody Trip partnerRequestData) {
        Optional<Trip> partnert = this.tripService.update(id, partnerRequestData);
        if (partnert.isPresent()) {
            return new ResponseEntity<Trip>(partnert.get(),HttpStatus.OK) ;
        } else {
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND) ;
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trip> deleteParnter(@PathVariable("id") Integer id) {
        try {
            this.tripService.remove(id);
            return new ResponseEntity<Trip>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Trip>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    

}
