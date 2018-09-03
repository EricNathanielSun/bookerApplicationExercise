package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Reservation;
import com.example.demo.model.ServiceFee;
import com.example.demo.repository.ServiceFeeRepository;

public class ServiceFeeService {

	private ServiceFeeRepository serviceFeeRepository;
	private ReservationService reservationService;
	
	public ServiceFeeService(ServiceFeeRepository serviceFeeRepository, ReservationService reservationService) {
		super();
		this.serviceFeeRepository = serviceFeeRepository;
		this.reservationService = reservationService;
	}


	public List<ServiceFee> findAllByReservationId(int reservationId)
	{
		Reservation reservation = reservationService.findById(reservationId);
		return serviceFeeRepository.findByReservation(reservation);
	}
	
}
