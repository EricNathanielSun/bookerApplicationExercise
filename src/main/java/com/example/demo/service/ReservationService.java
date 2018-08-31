package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

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
		List<Reservation> reservations = reservation.getCustomer().getReservations();
		// might not work as the "stored" reservations may be diff object with same vars
		customerService.save(reservation.getCustomer());
	}
	
	@Transactional
	private void setUpServiceModels(Reservation reservation)
	{
		for(ServiceModel service: reservation.getServiceModels())
		{
			if(!service.getReservations().contains(reservation))
			{
				service.getReservations().add(reservation);
			}
		}
		serviceService.saveAll(reservation.getServiceModels());
	}
}
