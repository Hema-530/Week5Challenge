package com.week3challenges.week3challenge.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.week3challenges.week3challenge.empentity.Employee;
import com.week3challenges.week3challenge.emprepository.EmployeeRepository;
import com.week3challenges.week3challenge.empservice.EmpService1;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpService1Test {

	@Autowired
    EmpService1 empService;
     
    @MockBean
    EmployeeRepository repository;
    
	@Test
    public void getAllEmployeesTest(){
        List<Employee> list = new ArrayList<Employee>();
        Employee employee1= new Employee(1, "Lokesh","Gupta",26,"TCS",123423);
		Employee employee2=new Employee(2,"Hema","Mothukuri",22,"TCS",522601);
		Employee employee3=new Employee(3,"Yams","Jose",20,"TCS",987654);
		Employee employee4=new Employee(4,"Sindhu","Johns",42,"TCS",165382);
		Employee employee5=new Employee(5,"Nani","Alexa",38,"TCS",837625);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
         
        Mockito.when(repository.findAll()).thenReturn(list);
         
       assertThat(empService.listAll()).isEqualTo(list);
		
    }
	
	/* @Test
	 void createEmployeeTest() {
	    	Employee emp=new Employee();
	    	emp.setId(6);
	    	emp.setForename("Sam");
	    	emp.setSurname("Ashok");
	    	emp.setAge(39);
	    	emp.setCompany("Infosys");
	    	emp.setPostcode(522601);
	    	//Optional<Employee> e1=Optional.of(emp);
	    	
	    	Mockito.when(repository.save(emp)).thenReturn(emp);
	    	assertThat(empService.addEmployee(emp)).isequalTo(emp);
	        //Assert.assertEquals( emp,empService.addEmployee(emp));
	 }
	 */
	 @Test
	  public void getEmployeeByIdTest() {
		 
		 Employee emp=new Employee();
		 emp.setId(2);
		 emp.setForename("Hema");
		 emp.setSurname("Mothukuri");
		 emp.setAge(22);
		 emp.setCompany("TCS");
		 emp.setPostcode(522601);
		 Optional<Employee> e=Optional.of(emp);
		 Mockito.when(repository.findById(2)).thenReturn(e);
		 assertThat(empService.findId(2)).isEqualTo(emp);
	 }
	
	 
	 
   

}
