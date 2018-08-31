package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationService {
	
	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
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
		return (List<Reservation>)reservationRepository.saveAll(reservations);
	}
	
	@Transactional
	public Reservation save(Reservation reservation)
	{
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

}
