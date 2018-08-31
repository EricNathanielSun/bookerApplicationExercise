package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Image;
import com.example.demo.model.ServiceModel;
import com.example.demo.repository.ServiceModelRepository;

public class ServiceService {
	private ServiceModelRepository serviceRepository;
	private ImageService imageService;

	public ServiceService(ServiceModelRepository serviceRepository,
			ImageService imageService) {
		super();
		this.serviceRepository = serviceRepository;
		this.imageService = imageService;
	}

	@Transactional
	public List<ServiceModel> findAll() {
		return (List<ServiceModel>)serviceRepository.findAll();
	}
	
	@Transactional
	public ServiceModel findById(int id)
	{
		return serviceRepository.findById(id).get();
	}
	
	@Transactional
	public List<ServiceModel> saveAll(List<ServiceModel> services)
	{
		for(ServiceModel service: services)
		{
			setUpImages(service);
		}
		return (List<ServiceModel>)serviceRepository.saveAll(services);
	}
	
	@Transactional
	public ServiceModel save(ServiceModel service)
	{
		setUpImages(service);
		return serviceRepository.save(service);
	}
	
	@Transactional
	public void delete(ServiceModel service)
	{
		serviceRepository.deleteById(service.getServiceModelId());
	}
	
	@Transactional
	public void deleteById(int id)
	{
		serviceRepository.deleteById(id);
	}
	
	@Transactional
	private void setUpImages(ServiceModel service)
	{
		for(Image image: service.getImages())
		{
			image.setServiceModel(service);
		}
		imageService.saveAll(service.getImages());
	}
}
