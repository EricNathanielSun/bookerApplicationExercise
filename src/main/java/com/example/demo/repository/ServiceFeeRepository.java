package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reservation;
import com.example.demo.model.ServiceFee;

@Repository
public interface ServiceFeeRepository extends CrudRepository<ServiceFee, Integer>{

	// Incorrect must just be findBy...
	public List<ServiceFee> findByReservation(Reservation reservation);
	
}
