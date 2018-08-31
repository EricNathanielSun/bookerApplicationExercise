package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
public class ServiceModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceModelId;
	private String serviceName;
	private String description;
	@OneToMany(mappedBy="serviceModel")
	private List<Image> images;
	
	@OneToMany(mappedBy="serviceModel")
	@JsonIgnore
	private List<ServiceFee> servicefees;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="travel_package_id")
	private TravelPackage travelPackage;
	
	@ManyToMany(mappedBy="serviceModels")
	@JsonIgnore
	private List<Reservation> reservations;
	
	public int getServiceModelId() {
		return serviceModelId;
	}

	public void setServiceModelId(int serviceModelId) {
		this.serviceModelId = serviceModelId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<ServiceFee> getServicefees() {
		return servicefees;
	}

	public void setServicefees(List<ServiceFee> servicefees) {
		this.servicefees = servicefees;
	}

	public TravelPackage getTravelPackage() {
		return travelPackage;
	}

	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
}
