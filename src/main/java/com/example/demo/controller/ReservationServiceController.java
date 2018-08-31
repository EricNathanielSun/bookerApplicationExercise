package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import com.example.demo.service.ServiceService;

@RestController
@RequestMapping("reservation/service")
public class ReservationServiceController {

	private ReservationService reservationService;
	private ServiceService serviceService;
	
	public ReservationServiceController(ReservationService reservationService, ServiceService serviceService) {
		super();
		this.reservationService = reservationService;
		this.serviceService = serviceService;
	}	

	/*
	@PutMapping
	public List<Reservation> updateReservationService(@RequestParam("reservationIds") List<Integer> reservationIds,
			@RequestParam("serviceModelIds") List<Integer> serviceModelIds)
	{
		
	}
	*/
	
}
