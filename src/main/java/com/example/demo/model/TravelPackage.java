package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
public class TravelPackage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int travelPackageId;
	private String packageName;
	@OneToMany(mappedBy="travelPackage")
	private List<ServiceModel> serviceModels;
	@OneToMany(mappedBy="travelPackage")
	private List<Image> images;
	private String description;
	
	@OneToMany(mappedBy="travelPackage")
	@JsonIgnore
	private List<Feedback> feedback;

	public int getTravelPackageId() {
		return travelPackageId;
	}

	public void setTravelPackageId(int travelPackageId) {
		this.travelPackageId = travelPackageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ServiceModel> getServiceModels() {
		return serviceModels;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public void setServiceModels(List<ServiceModel> serviceModels) {
		this.serviceModels = serviceModels;
	}

}
