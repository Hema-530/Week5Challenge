package com.week3challenges.week3challenge.repository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.week3challenges.week3challenge.empentity.Employee;
import com.week3challenges.week3challenge.emprepository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
	 @Autowired
	   EmployeeRepository repository;
	    
	   @Test
	    public void testRepository() {
	       Employee emp = new Employee();
	       emp.setId(1);
	       emp.setForename("Lokesh");
	       emp.setSurname("Gupta");
	       emp.setAge(40);
	       emp.setCompany("TCS");
	       emp.setPostcode(3456788);
	        
	       repository.save(emp);
	        
	       Assert.assertNotNull(emp.getId());
	   }
	   @Test
	     public void testDeleteEmployee() {
	        Employee employee = new Employee(1,"Lokesh", "Gupta",40, "TCS",3456788);
	        repository.save(employee);
	        repository.delete(employee);
	    }
}

