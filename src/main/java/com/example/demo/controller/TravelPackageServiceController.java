package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ServiceModel;
import com.example.demo.service.ServiceService;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages/{travelPackageId}/services")
public class TravelPackageServiceController {
	private TravelPackageService travelPackageService;
	private ServiceService ServiceService;

	public TravelPackageServiceController(TravelPackageService travelPackageService,
			ServiceService serviceService) {
		super();
		this.travelPackageService = travelPackageService;
		ServiceService = serviceService;
	}

	@GetMapping
	public List<ServiceModel> getAllServiceModelsOfTravelPackage(@PathVariable("travelPackageId") int id)
	{
		return travelPackageService.findById(id).getServiceModels();
	}
	
	@GetMapping("/{serviceId}")
	public ServiceModel getServiceModelOfTravelPackage(@PathVariable("serviceId") int id)
	{
		return ServiceService.findById(id);
	}
	
	@PutMapping
	public List<ServiceModel> updateServiceModelsOfTravelPackage(@RequestBody List<ServiceModel> serviceModels)
	{
		return ServiceService.saveAll(serviceModels);
	}
	
	@PutMapping("/{serviceId}")
	public ServiceModel updateServiceModelOfTravelPackage(@RequestBody ServiceModel serviceModel,
			@PathVariable("serviceId") int id)
	{
		serviceModel.setServiceModelId(id);
		return ServiceService.save(serviceModel);
	}
	
	@PostMapping
	public List<ServiceModel> createServiceModelsOfTravelPackage(@RequestBody List<ServiceModel> serviceModels)
	{
		return ServiceService.saveAll(serviceModels);
	}
	
	@DeleteMapping
	public void deleteServiceModelsOfTravelPackage(@RequestBody List<ServiceModel> serviceModels)
	{
		for(ServiceModel service: serviceModels)
		{
			ServiceService.delete(service);
		}
	}
	
	@DeleteMapping("/{serviceId}")
	public void deleteServiceModelOfTravelPackage(@PathVariable("serviceId") int id)
	{
		ServiceService.deleteById(id);
	}
}
