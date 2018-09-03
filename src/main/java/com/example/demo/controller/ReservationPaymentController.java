package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ServiceFee;
import com.example.demo.service.ServiceFeeService;

@RestController
@RequestMapping("/reservations/{reservationId}/payment")
public class ReservationPaymentController {

	private ServiceFeeService serviceFeeService;

	public ReservationPaymentController(ServiceFeeService serviceFeeService) {
		super();
		this.serviceFeeService = serviceFeeService;
	}

	@GetMapping
	public List<ServiceFee> getAllServiceFeesByReservation(@PathVariable("reservationId") int reservationId) {
		return serviceFeeService.findAllByReservationId(reservationId);
	}

}
