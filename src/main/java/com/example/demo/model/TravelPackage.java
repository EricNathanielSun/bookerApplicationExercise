package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@JsonIdentityInfo(generator=PropertyGenerator.class, property="travelPackageId")
public class TravelPackage {
	@Id
	@GeneratedValue
	private int travelPackageId;
	private String packageName;
	@OneToMany(mappedBy="travelPackage")
	private List<ServiceModel> serviceModels;
	@OneToMany(mappedBy="travelPackage")
	private List<Image> images;
	private String description;

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

	public void setServices(List<ServiceModel> serviceModels) {
		this.serviceModels = serviceModels;
	}

}
