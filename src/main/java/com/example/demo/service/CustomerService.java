package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {
	
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	@Transactional
	public List<Customer> findAll()
	{
		return (List<Customer>)customerRepository.findAll();
	}
	
	@Transactional
	public Customer findById(int id)
	{
		return customerRepository.findById(id).get();
	}
	
	@Transactional
	public List<Customer> saveAll(List<Customer> customers)
	{
		return (List<Customer>)customerRepository.saveAll(customers);
	}
	
	@Transactional
	public Customer save(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void deleteAll(List<Integer> ids)
	{
		List<Customer> customers = (List<Customer>)customerRepository.findAllById(ids);
		customerRepository.deleteAll(customers);
	}
	
	@Transactional
	public void delete(Customer customer)
	{
		customerRepository.deleteById(customer.getCustomerId());
	}
	
	@Transactional
	public void deleteById(int id)
	{
		customerRepository.deleteById(id);
	}
}
