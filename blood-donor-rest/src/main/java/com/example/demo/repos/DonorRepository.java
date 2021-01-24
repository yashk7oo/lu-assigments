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

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor , Long> {
	
          List<Donor> findByBloodGroup(String bloodGroup);
          List<Donor> findByCity(String city);
          
 
          
          @Query(value=" select * from donor where dateOfLastDonation<=DATE(NOW() - INTERVAL 6 MONTH)",nativeQuery = true)
          @Transactional
          List<Donor> findEligibleDonors();
          
         
	

}
