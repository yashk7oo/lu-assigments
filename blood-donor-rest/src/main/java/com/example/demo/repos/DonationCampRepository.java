package com.example.demo.repos;

import java.time.LocalDate;

import java.time.Period;
import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.Donor;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp , Long> {
	
          List<DonationCamp> findByCampName(String campName);
          List<DonationCamp> findByCampCity(String campCity);
          
          @Query(value=" select distinct campName from donation_camp ",nativeQuery = true)
          @Transactional
          List<String> findUniqueCamps();
          
           

}
