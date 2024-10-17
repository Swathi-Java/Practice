package com.lancesoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancesoft.entity.Manager;
import com.lancesoft.entity.Technologies;
import com.lancesoft.entity.TechnologyResponse;
import com.lancesoft.service.TechnologiesServiceImpl;
@CrossOrigin("*")
@RestController
public class TechnologiesController {
	@Autowired
	TechnologiesServiceImpl technologiesServiceImpl;
	
	@PostMapping("/addTechnologies")
  public Technologies addTechnologies(@RequestBody Technologies Technologies)
  {  
	technologiesServiceImpl.saveTechnologies(Technologies);
	return Technologies;
  }
	@GetMapping("/AllTechnologies")
	public List<Technologies> alltechnologies(Technologies technologies)
	{
		
		return technologiesServiceImpl.getAllTechnologies();
	}
	@GetMapping("/getManager")
	public List<Manager> getmanager(@RequestParam String technologies)
	{
		return technologiesServiceImpl.getman(technologies); 
	}
	@GetMapping("/TechnologiesResponse")
	public List<TechnologyResponse> techresponse()
	{
		return technologiesServiceImpl.techdetails();
		}
}
