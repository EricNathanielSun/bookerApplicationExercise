package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll()
	{
		return (List<Customer>)customerRepository.findAll();
	}
	
	public Customer findById(int id)
	{
		return customerRepository.findById(id).get();
	}
	
	public List<Customer> saveAll(List<Customer> customers)
	{
		return (List<Customer>)customerRepository.saveAll(customers);
	}
	
	public Customer save(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public void deleteAll(List<Integer> ids)
	{
		List<Customer> customers = (List<Customer>)customerRepository.findAllById(ids);
		customerRepository.deleteAll(customers);
	}
	
	public void delete(Customer customer)
	{
		customerRepository.deleteById(customer.getCustomerId());
	}
	
	public void deleteById(int id)
	{
		customerRepository.deleteById(id);
	}
}
