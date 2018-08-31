package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Feedback;
import com.example.demo.model.Reservation;
import com.example.demo.model.TravelPackage;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

	public List<Feedback> findByTravelPackage(TravelPackage travelPackage);
	public List<Feedback> findByReservation(Reservation reservation);
}
