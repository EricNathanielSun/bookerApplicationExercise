package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reservationId;
	private String departureDate;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="reservation")
	@JsonIgnore
	private List<Feedback> feedbacks;
	
	@OneToMany(mappedBy="reservation")
	@JsonIgnore
	private List<ServiceFee> serviceFees;
	
	@ManyToMany
	@JoinTable
	private List<ServiceModel> serviceModels;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<ServiceModel> getServiceModels() {
		return serviceModels;
	}

	public void setServiceModels(List<ServiceModel> serviceModels) {
		this.serviceModels = serviceModels;
	}

	public List<ServiceFee> getServiceFees() {
		return serviceFees;
	}

	public void setServiceFees(List<ServiceFee> serviceFees) {
		this.serviceFees = serviceFees;
	}

}
