package com.kashsoftwares.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kashsoftwares.dao.CustomerDAO;
import com.kashsoftwares.entity.Customer;
import com.kashsoftwares.service.CustomerService;
import com.kashsoftwares.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the dao
		List<Customer> customerList = customerService.getCustomers();
		
		// add customers to the model
		theModel.addAttribute("customers", customerList);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind  form data
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer
		
		customerService.saveCustomer(theCustomer);
		//System.out.println("Inside addCustomer Controller:");
		
		return "redirect:/customer/list";
		
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {
		
		// get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		
		// set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId,
			 Model theModel) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
	}

	
}

