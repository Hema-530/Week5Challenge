package com.week3challenges.week3challenge.empservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.week3challenges.week3challenge.empentity.Employee;



@Service
public interface EmpService1 {

	

	List<Employee> listAll();

	void addEmployee(Employee emp);

	Employee findId(Integer id);

	Object updateEmployee(int id, Employee e);
	


}