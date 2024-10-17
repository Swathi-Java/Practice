package com.lancesoft.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lancesoft.entity.EmployeeCount;
import com.lancesoft.entity.EmployeeResponse;
import com.lancesoft.entity.EmployeesEntity;
import com.lancesoft.entity.HeadsEntity;
import com.lancesoft.service.EmployeesServiceImpl;
@CrossOrigin("*")
@RestController
public class EmployeesController {
	@Autowired
	EmployeesServiceImpl employeesServiceImpl;

	@PostMapping("/addEmployees")
	public EmployeesEntity addemployees(@RequestParam String employeesimage,MultipartFile file,HeadsEntity headsEntity) throws IOException
	{
		ObjectMapper objectMapper=new ObjectMapper();
	EmployeesEntity employeesEntity=objectMapper.readValue(employeesimage, EmployeesEntity.class);
		return employeesServiceImpl.saveemployees(employeesEntity,file,headsEntity);
		
	}

	@GetMapping("/getEmployees")
	public List<EmployeeResponse>  employees(@RequestParam String technology ,@RequestParam String manager)
	{
		return employeesServiceImpl.getemployee(technology,manager);
	}
	@GetMapping("/count")
	public EmployeeCount getprojects(@RequestParam String technology,@RequestParam String manager,EmployeeCount employeeCount)
	{
		return  employeesServiceImpl.getcount(technology,manager,employeeCount);
	}
	@GetMapping("/image")
	public ResponseEntity<byte[]> employeeimage(@RequestParam String name) {
		return employeesServiceImpl.gettimages(name);
	}
}	
