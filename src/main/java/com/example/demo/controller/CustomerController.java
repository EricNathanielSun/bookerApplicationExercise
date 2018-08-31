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

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		return customerService.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") int id)
	{
		return customerService.findById(id);
	}
	
	@PutMapping
	public List<Customer> updateCustomers(@RequestBody List<Customer> customers)
	{
		return customerService.saveAll(customers);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id)
	{
		customer.setCustomerId(id);
		return customerService.save(customer);
	}
	
	@PostMapping
	public List<Customer> createCustomers(@RequestBody List<Customer> customers)
	{
		return customerService.saveAll(customers);
	}
	
	@DeleteMapping
	public void deleteCustomers(@RequestParam("customerIdList") List<Integer> customerIdList)
	{
		customerService.deleteAll(customerIdList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") int id)
	{
		customerService.deleteById(id);
	}
}
