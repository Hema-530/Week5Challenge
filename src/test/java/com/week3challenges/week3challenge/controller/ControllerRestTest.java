package com.week3challenges.week3challenge.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.week3challenges.week3challenge.empcontroller.ControllerRest;
import com.week3challenges.week3challenge.empentity.Employee;
import com.week3challenges.week3challenge.emprepository.EmployeeRepository;
import com.week3challenges.week3challenge.empservice.EmpService1;


@WebMvcTest(ControllerRest.class)
class ControllerRestTest  {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmpService1 service;
	
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	 void testEmployeeList() throws Exception {
		List<Employee> list=new ArrayList<>();
		
		list.add(new Employee(1,"Lokesh","Gupta",26,"TCS",123423));
		list.add(new Employee(2,"Hema","Mothukuri",22,"TCS",522601));
		list.add(new Employee(3,"Yams","Jose",20,"TCS",987654));
		
		Mockito.when(service.listAll()).thenReturn(list);
		
		/*   String url="/empser";
		
		MvcResult mvcResult=mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		//byte[] bytes=mvcResult.getResponse().getContentAsByteArray();
		//Path path=Paths.get("employee.pdf");
		//Files.write(path, bytes);      */
		
		String url="/empser";
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson=this.mapToJson(list);
		String outputJson=mvcResult.getResponse().getContentAsString();
		
		assertThat(outputJson).isEqualTo(expectedJson);
		System.out.println(outputJson);
		
	}
	
	@Test
	 void testUpdateEmployee() throws Exception {
		Employee e=new Employee();
		int id=2;
   	 	e.setId(2);
		e.setForename("Sam");
		e.setSurname("Siva");;
		e.setAge(38);
		e.setCompany("Hyundai");
		e.setPostcode(876540);
		Optional<Employee> e1=Optional.of(e);
		Mockito.when(repository.findById(id)).thenReturn(e1);
		
		Mockito.when(service.updateEmployee(id,e)).thenReturn(e1);
		
		 String URI="/emp/{id}";
		String expectedJson = this.mapToJson(e);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/emp/"+id)
				.accept(MediaType.APPLICATION_JSON).content(expectedJson)
				.contentType(MediaType.APPLICATION_JSON);;
				MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
				MockHttpServletResponse response = result.getResponse();
				String outputInJson = response.getContentAsString();
				
				
				assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	 protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
}
