package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public List<Reservation> getAllReservations()
	{
		return reservationService.findAll();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable("id") int id)
	{
		return reservationService.findById(id);
	}
	
	@PutMapping
	public List<Reservation> updateReservations(@RequestBody List<Reservation> reservations)
	{
		return reservationService.saveAll(reservations);
	}
	
	@PutMapping("/{id}")
	public Reservation updateReservation(@RequestBody Reservation reservation,@PathVariable("id") int id)
	{
		reservation.setReservationId(id);
		return reservationService.save(reservation);
	}
	
	@PostMapping
	public List<Reservation> createReservations(@RequestBody List<Reservation> reservations)
	{
		return reservationService.saveAll(reservations);
	}
	
	@DeleteMapping
	public void deleteReservations(@RequestParam("reservationIdList") List<Integer> reservationIdList)
	{
		reservationService.deleteAll(reservationIdList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable("id") int id)
	{
		reservationService.deleteById(id);
	}
}
