package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.model.ServiceModel;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;

@Service
public class TravelPackageService {
	private TravelPackageRepository travelPackageRepository;
	private ImageService imageService;
	private ServiceService serviceService;

	public TravelPackageService(TravelPackageRepository travelPackageRepository,
			ImageService imageService, ServiceService serviceService) {
		super();
		this.imageService = imageService;
		this.travelPackageRepository = travelPackageRepository;
		this.serviceService = serviceService;
	}
	
	@Transactional
	public List<TravelPackage> findAll()
	{
		return (List<TravelPackage>)travelPackageRepository.findAll();
	}
	
	@Transactional
	public TravelPackage findById(int id)
	{
		return travelPackageRepository.findById(id).get();
	}
	
	@Transactional
	public List<TravelPackage> saveAll(List<TravelPackage> travelPackages)
	{
		for(TravelPackage travelPackage: travelPackages)
		{
			setUpImagesAndServices(travelPackage);
		}
		return (List<TravelPackage>)travelPackageRepository.saveAll(travelPackages);
	}
	
	@Transactional
	public TravelPackage save(TravelPackage travelPackage)
	{
		setUpImagesAndServices(travelPackage);
		return travelPackageRepository.save(travelPackage);
	}
	
	@Transactional
	public void deleteAll(List<Integer> ids)
	{
		List<TravelPackage> travelPackages = (List<TravelPackage>)travelPackageRepository.findAllById(ids);
		travelPackageRepository.deleteAll(travelPackages);
	}
	
	@Transactional
	public void delete(TravelPackage travelPackage)
	{
		travelPackageRepository.deleteById(travelPackage.getTravelPackageId());
	}
	
	@Transactional
	public void deleteById(int id)
	{
		travelPackageRepository.deleteById(id);
	}
	
	@Transactional
	private void setUpImagesAndServices(TravelPackage travelPackage)
	{
		for(Image image: travelPackage.getImages())
		{
			image.setTravelPackage(travelPackage);
		}
		imageService.saveAll(travelPackage.getImages());
		
		for(ServiceModel serviceModel: travelPackage.getServiceModels())
		{
			serviceModel.setTravelPackage(travelPackage);
		}
		serviceService.saveAll(travelPackage.getServiceModels());
	}
}
