package com.formacion.jpa.Trip;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.formacion.jpa.Sailor.Sailor;

@Repository
public interface TripRepository extends JpaRepository<Trip,Integer>{

    @Query("SELECT s.name, COUNT(t.id)  FROM Trip t JOIN t.sailor s GROUP BY s.name")
    List<String> findSailorsWithMoreExpertice(); 



}
