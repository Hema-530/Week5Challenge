package com.week3challenges.week3challenge.empcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.week3challenges.exceptionhandling.RecordNotFoundException;
import com.week3challenges.week3challenge.empentity.Employee;
import com.week3challenges.week3challenge.empservice.EmpService1;


@Controller

public class Controller1 {
	@Autowired 
		EmpService1 empservice;
		@RequestMapping(value = "/home")
		public String home(){
			return "view" ;
			
		}
		
		@GetMapping("/getdetails")
		public String  getEmployee(Model m){
		  List<Employee> emplist = empservice.listAll();
		  	
		    m.addAttribute("emplist", emplist);
		     
		    return "index";
		}
		@GetMapping("/emps")
		public String showSearchEmployeePage(Model model){
			
			return "search";
			
		}
		@GetMapping(value ="/get")
		  public String  getEmployee( @Param("keyword") String keyword,Model m)throws RecordNotFoundException{ 
		  int i=Integer.parseInt(keyword);  
		  
			  Employee  emplist= empservice.findId(i);
			
			  if(emplist != null) {
				m.addAttribute("emplist", emplist);
				
				     
				    return "index2";
			}
			  else {
				  m.addAttribute("emplist","Invalid id");
				  return "search";
				  
			  }
				   
			
			
			
		  }
		@RequestMapping("/addemployee")
		public String showNewEmployeePage(Model model) {
		    Employee emp = new Employee();
		    model.addAttribute("emp", emp);
		     
		    return "form";
		}
		@PostMapping(value = "/ADD")
		public String saveEmployee(@Valid @ModelAttribute("emp") Employee emp,Errors errors) {
			if (errors.hasErrors()) {
				return "form";
			}
			else {
		    empservice.addEmployee(emp);
		     
		    return "success";
		    }
		}
		
}

