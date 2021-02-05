package com.week3challenges.week3challenge.empservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week3challenges.week3challenge.empentity.Employee;
import com.week3challenges.week3challenge.emprepository.EmployeeRepository;



@Service
@Transactional
public class Service1 implements EmpService1 {
	@Autowired
	private EmployeeRepository emrp;
	
	@Override
	public List<Employee> listAll() {
		return emrp.findAll();
	}
	
	@Override
	public void addEmployee(Employee emp) {
		emrp.save(emp);
	}
	
	@Override
	public  Employee findId(Integer id ) {
	
		return emrp.findById(id).orElse(null);
	  
	}

	@Override
	public Object updateEmployee(int id, Employee e) {
		return null;
	}

}
