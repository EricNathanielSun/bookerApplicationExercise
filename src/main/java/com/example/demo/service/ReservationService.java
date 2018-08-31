package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.model.ServiceModel;
import com.example.demo.repository.ReservationRepository;

public class ReservationService {
	
	private ReservationRepository reservationRepository;
	private CustomerService customerService;
	private ServiceService serviceService;
	
	public ReservationService(ReservationRepository reservationRepository, CustomerService customerService,
			ServiceService serviceService) {
		super();
		this.reservationRepository = reservationRepository;
		this.customerService = customerService;
		this.serviceService = serviceService;
	}

	@Transactional
	public List<Reservation> findAll()
	{
		return (List<Reservation>)reservationRepository.findAll();
	}
	
	@Transactional
	public Reservation findById(int id)
	{
		return reservationRepository.findById(id).get();
	}
	
	@Transactional
	public List<Reservation> saveAll(List<Reservation> reservations)
	{
		for(Reservation reservation: reservations)
		{
			setUpCustomer(reservation);
			setUpServiceModels(reservation);
		}
		return (List<Reservation>)reservationRepository.saveAll(reservations);
	}
	
	@Transactional
	public Reservation save(Reservation reservation)
	{
		setUpCustomer(reservation);
		setUpServiceModels(reservation);
		return reservationRepository.save(reservation);
	}
	
	@Transactional
	public void deleteAll(List<Integer> ids)
	{
		List<Reservation> reservations = (List<Reservation>)reservationRepository.findAllById(ids);
		reservationRepository.deleteAll(reservations);
	}
	
	@Transactional
	public void delete(Reservation reservation)
	{
		reservationRepository.deleteById(reservation.getReservationId());
	}
	
	@Transactional
	public void deleteById(int id)
	{
		reservationRepository.deleteById(id);
	}

	@Transactional
	private void setUpCustomer(Reservation reservation)
	{
		Customer customer = customerService.findById(reservation.getCustomer().getCustomerId());
		reservation.getCustomer().setReservations(customer.getReservations());
		List<Reservation> cReservations = reservation.getCustomer().getReservations();
		boolean hasReservation = false;
		for(Reservation cReservation: cReservations)
		{
			if(cReservation.getReservationId() == reservation.getReservationId())
			{
				hasReservation = true;
				break;
			}
		}
		if(!hasReservation)
		{
			reservation.getCustomer().getReservations().add(reservation);
		}
		customerService.save(reservation.getCustomer());
	}
	
	@Transactional
	private void setUpServiceModels(Reservation reservation)
	{
		boolean hasReservation = false;
		for(ServiceModel service: reservation.getServiceModels())
		{
			ServiceModel actualService = serviceService.findById(service.getServiceModelId());
			service.setReservations(actualService.getReservations());
			for(Reservation sReservation: service.getReservations())
			{
				if(sReservation.getReservationId() == reservation.getReservationId())
				{
					hasReservation = true;
				}
			}
			if(!hasReservation)
			{
				service.getReservations().add(reservation);
			}
		}
		serviceService.saveAll(reservation.getServiceModels());
	}
}
