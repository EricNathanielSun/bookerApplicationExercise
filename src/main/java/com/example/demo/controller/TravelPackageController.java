package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TravelPackage;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {
	private TravelPackageService travelPackageService;

	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}
	
	@GetMapping
	public List<TravelPackage> getAllTravelPackages()
	{
		return travelPackageService.findAll();
	}
	
	@GetMapping("/{id}")
	public TravelPackage getTravelPackageById(@PathVariable("id") int id)
	{
		return travelPackageService.findById(id);
	}
	
	@PutMapping
	public List<TravelPackage> updateTravelPackages(@RequestBody List<TravelPackage> travelPackages)
	{
		return travelPackageService.saveAll(travelPackages);
	}
	
	@PutMapping("/{id}")
	public TravelPackage updateTravelPackage(@RequestBody TravelPackage travelPackage,@PathVariable("id") int id)
	{
		travelPackage.setTravelPackageId(id);
		return travelPackageService.save(travelPackage);
	}
	
	@PostMapping
	public List<TravelPackage> createTravelPackages(@RequestBody List<TravelPackage> travelPackages)
	{
		return travelPackageService.saveAll(travelPackages);
	}
	
	@DeleteMapping
	public void deleteTravelPackages(@RequestParam("travelPackageIdList") List<Integer> travelPackageIdList)
	{
		travelPackageService.deleteAll(travelPackageIdList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTravelPackage(@PathVariable("id") int id)
	{
		travelPackageService.deleteById(id);
	}
}
