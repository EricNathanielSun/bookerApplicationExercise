package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Feedback;
import com.example.demo.model.Reservation;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.FeedbackRepository;

public class FeedbackService {

	private FeedbackRepository feedbackRepository;
	private TravelPackageService travelPackageService;
	private ReservationService reservationService;
	
	public FeedbackService(FeedbackRepository feedbackRepository, TravelPackageService travelPackageService,
			ReservationService reservationService) {
		super();
		this.feedbackRepository = feedbackRepository;
		this.travelPackageService = travelPackageService;
		this.reservationService = reservationService;
	}

	@Transactional
	public List<Feedback> findAll()
	{
		return (List<Feedback>) feedbackRepository.findAll();
	}

	@Transactional
	public Feedback findById(int id)
	{
		return feedbackRepository.findById(id).get();
	}

	@Transactional
	public List<Feedback> findByTravelPackageId(int travelPackageId)
	{
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		return feedbackRepository.findByTravelPackage(travelPackage);
	}

	@Transactional
	public List<Feedback> findByReservationId(int reservationId)
	{
		Reservation reservation = reservationService.findById(reservationId);
		return feedbackRepository.findByReservation(reservation);
	}

	@Transactional
	public List<Feedback> saveAll(List<Feedback> feedbacks)
	{
		for(Feedback feedback: feedbacks)
		{
			setUpReservation(feedback, feedback.getReservation());
		}
		return (List<Feedback>) feedbackRepository.saveAll(feedbacks);
	}

	@Transactional
	public List<Feedback> saveAllByTravelPackageId(List<Feedback> feedbacks, int travelPackageId)
	{
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		for(Feedback feedback: feedbacks)
		{
			setUpTravelPackage(feedback, travelPackage);
			setUpReservation(feedback, feedback.getReservation());
		}
		return (List<Feedback>) feedbackRepository.saveAll(feedbacks);
	}

	@Transactional
	public Feedback save(Feedback feedback)
	{
		setUpReservation(feedback, feedback.getReservation());
		return feedbackRepository.save(feedback);
	}

	@Transactional
	public void deleteAll(List<Integer> ids)
	{
		List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAllById(ids);
		feedbackRepository.deleteAll(feedbacks);
	}
	
	@Transactional
	public void delete(int id)
	{
		feedbackRepository.deleteById(id);
	}
	
	@Transactional
	private void setUpTravelPackage(Feedback feedback, TravelPackage travelPackage)
	{
		boolean hasFeedback = false;
		for(Feedback tPFeedback: travelPackage.getFeedback())
		{
			if(tPFeedback.getFeedbackId() == feedback.getFeedbackId())
			{
				hasFeedback = true;
				break;
			}
		}
		if(!hasFeedback)
		{
			travelPackage.getFeedback().add(feedback);
		}
		travelPackageService.save(travelPackage);
		feedback.setTravelPackage(travelPackage);
	}
	
	@Transactional
	private void setUpReservation(Feedback feedback, Reservation reservation)
	{
		feedback.setReservation(reservation);
		// might not work as it may be a new object with just same vars
		reservationService.save(reservation);
	}
}
