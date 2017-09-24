package com.orderplacement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderplacement.entity.Customer;
import com.orderplacement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private enum Service_list {moving, packing, cleaning}


	// injecting service (-> dao)
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customers =  customerService.getCustomers();
		// add customers to spring mvc model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("all_services", Service_list.values());
		
		return "customer-form";
	}
	
	
	@PostMapping("/actionSaveDelete") 
	public String actionSaveDelete(@ModelAttribute("customer") Customer customer, @RequestParam("action") String action) {
		if (action.equals("Save")) {
			customerService.saveCustomer(customer);
		} else if (action.matches("Delete.*")) {
			customerService.deleteCustomer(customer);
		} else {
			System.out.println("actionSaveDelete: Impossible action >" + action + "<");
		}
		return "redirect:/customer/list";
	}	
	
	@GetMapping("/findCustomers")
	public String findCustomers(@RequestParam("searchQuery") String sQuery, Model model) {

		List<Customer> customers =  customerService.findCustomers(sQuery);
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		model.addAttribute("all_services", Service_list.values());
	
		return "customer-form";
	}
	

	// debug function
	/*private void printCustomers(List<Customer> customers) {
		for (Customer c: customers) {
			System.out.println(c);
		}
	}*/
	
}

































