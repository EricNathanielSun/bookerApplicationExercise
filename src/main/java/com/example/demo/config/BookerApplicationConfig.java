package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.ServiceModelRepository;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ImageService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.TravelPackageService;

@Configuration
public class BookerApplicationConfig {

	@Bean
	public CustomerService customerService(CustomerRepository customerRepository)
	{
		return new CustomerService(customerRepository);
	}
	
	@Bean
	public ImageService imageService(ImageRepository imageRepository)
	{
		return new ImageService(imageRepository);
	}
	
	@Bean
	public ReservationService reservationService(ReservationRepository reservationRepository)
	{
		return new ReservationService(reservationRepository);
	}
	
	@Bean
	public ServiceService serviceService(ServiceModelRepository serviceRepository, ImageService imageService)
	{
		return new ServiceService(serviceRepository, imageService);
	}
	
	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository,
			ImageService imageService, ServiceService serviceService)
	{
		return new TravelPackageService(travelPackageRepository, imageService, serviceService);
	}
}
