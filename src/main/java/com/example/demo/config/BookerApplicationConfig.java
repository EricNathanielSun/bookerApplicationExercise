package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.ServiceFeeRepository;
import com.example.demo.repository.ServiceModelRepository;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.ImageService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.ServiceFeeService;
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
	public ReservationService reservationService(ReservationRepository reservationRepository,
			CustomerService customerService, ServiceService serviceService)
	{
		return new ReservationService(reservationRepository, customerService, serviceService);
	}
	
	@Bean
	public ServiceService serviceService(ServiceModelRepository serviceRepository,
			ImageService imageService)
	{
		return new ServiceService(serviceRepository, imageService);
	}
	
	@Bean
	public ServiceFeeService serviceFeeService(ServiceFeeRepository serviceFeeRepository, ReservationService reservationService)
	{
		return new ServiceFeeService(serviceFeeRepository, reservationService);
	}
	
	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository,
			ImageService imageService, ServiceService serviceService)
	{
		return new TravelPackageService(travelPackageRepository, imageService, serviceService);
	}
	
	@Bean
	public FeedbackService feedbackService(FeedbackRepository feedbackRepository,
			TravelPackageService travelPackageService, ReservationService reservationService)
	{
		return new FeedbackService(feedbackRepository, travelPackageService, reservationService);
	}
}
