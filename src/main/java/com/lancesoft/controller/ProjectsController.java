package com.lancesoft.controller;

import java.io.IOException;
import java.util.HashSet;
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
import com.lancesoft.dao.ProjectName;
import com.lancesoft.entity.Proj;
import com.lancesoft.entity.ProjectsEntity;
import com.lancesoft.service.ProjectServiceImpl;
@CrossOrigin("*")
@RestController
public class ProjectsController {
	@Autowired
	 ProjectServiceImpl projectServiceImpl;
	
	@PostMapping("/projects")
	public ProjectsEntity addprojects(@RequestParam String addingprojects ,@RequestParam MultipartFile file,@RequestParam MultipartFile file1 )throws IOException
	{
		  ObjectMapper objectMapper = new ObjectMapper();
		ProjectsEntity projec=objectMapper.readValue(addingprojects, ProjectsEntity.class);
		return projectServiceImpl.saveverticals(projec,file,file1);
	}

	@GetMapping("/AllProjects")
	public List<ProjectsEntity> allprojects()
	{
		return projectServiceImpl.allprojects();
	}
	@GetMapping("/projectNames")//--names only
	public HashSet<String> projectdetails(@RequestParam String technology,@RequestParam String manager,ProjectName projectName)
	{
		return projectServiceImpl.projectName(technology,manager,projectName);
	}
	@GetMapping("/Whitepaper")
	public ResponseEntity<byte []> projectspdf(@RequestParam String projects)
	{
		return projectServiceImpl.whitepaper(projects);
	}
	@GetMapping("/CaseStudy")
	
		public ResponseEntity<byte []> projectpdf(@RequestParam String projects)
		{
			return projectServiceImpl.CaseStudy(projects);
		}
		@GetMapping("/projectdetails")//get project Names and Employee count and status
		public List<Proj> projectdetails1(@RequestParam String technology,@RequestParam String manager,Proj proj)
		{
			return projectServiceImpl.projectName1(technology,manager,proj);
		}
		@GetMapping("/getProjectNames")
		public List<ProjectsEntity> projectNames(@RequestParam String headid)
		{
			return projectServiceImpl.projectsNames(headid);
		}
}

