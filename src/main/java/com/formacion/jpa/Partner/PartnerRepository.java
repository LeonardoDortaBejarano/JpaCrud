package com.formacion.jpa.Partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.jpa.Sailor.SailorRepository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long>{


}
