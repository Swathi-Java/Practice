package com.lancesoft.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lancesoft.dao.EmployeesDao;
import com.lancesoft.dao.HeadsDao;
import com.lancesoft.dao.ProjectName;
import com.lancesoft.dao.ProjectsDao;
import com.lancesoft.dao.TechnologiesDao;
import com.lancesoft.entity.EmployeesEntity;
import com.lancesoft.entity.HeadsEntity;
import com.lancesoft.entity.Proj;
import com.lancesoft.entity.ProjectsEntity;
import com.lancesoft.entity.Technologies;

@Service
public class ProjectServiceImpl implements ProjectsService {
	@Autowired
	ProjectsDao projectsDao;
	@Autowired
	HeadsDao headsDao;
	@Autowired
	TechnologiesDao technologiesDao;
	@Autowired
	EmployeesDao employeesDao;
	@Autowired
	HttpServletResponse httpServletResponse;

	@Override
	public ProjectsEntity saveverticals(ProjectsEntity projectsEntity, MultipartFile file, MultipartFile file1)
			throws IOException {

		projectsEntity.setWhitepaper(file.getBytes());
		projectsEntity.setCaseStudy(file1.getBytes());
		Technologies technologies=technologiesDao.findBytechnologies(projectsEntity.getTechnologies().getTechnologies());
		projectsEntity.setTechnologies(technologies);
		HeadsEntity heads=headsDao.findByHdId(projectsEntity.getHeadsentity().getHdId());
		projectsEntity.setHeadsentity(heads);
		return projectsDao.save(projectsEntity);
	}

	@Override
	public List<ProjectsEntity> allprojects() {

		return projectsDao.findAll();
	}

	@Override
	public HashSet<String> projectName(String technology, String manager, ProjectName projectName) {

		HashSet<String> projects = new HashSet<>();
		HeadsEntity headsEntity=headsDao.findByHeadname(manager);
		List<EmployeesEntity> employe = employeesDao.findByManagerAndTechnology(headsEntity, technology);

		for (EmployeesEntity employeesEntity : employe) {

			projects.add(employeesEntity.getProjects());
		}

		return projects;
	}

	@Override
	public ResponseEntity<byte[]> whitepaper(String projects) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
		httpServletResponse.setContentType("application/pdf");

		return new ResponseEntity<>(projectsDao.findByProjects(projects).get(0).getWhitepaper(), headers,
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<byte[]> CaseStudy(String caseStudy) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
		httpServletResponse.setContentType("application/pdf");
		return new ResponseEntity<byte[]>(projectsDao.findByProjects(caseStudy).get(0).getCaseStudy(), header,
				HttpStatus.OK);
	}

	@Override
	public List<Proj> projectName1(String technology, String manager, Proj proj) {

		List<Proj> projs = new ArrayList<>();
		HeadsEntity headsEntity=headsDao.findByHeadname(manager);
		List<EmployeesEntity> employe = employeesDao.findByManagerAndTechnology(headsEntity, technology);
		HashSet<String> set = new HashSet<>();
		for (EmployeesEntity employeesEntity : employe) {
			set.add(employeesEntity.getProjects());
		}

		for (String projNames : set) {

			List<EmployeesEntity> employeeFiltered = employeesDao.findByProjects(projNames);
			Proj proj2 = new Proj();
			proj2.setEmployeeCount(employeeFiltered.size());
			proj2.setProjectName(projNames);
			proj2.setStatus(projectsDao.findByProjects(projNames).get(0).getStatus());
			projs.add(proj2);

		}

		return projs;
	}

	@Override
	public List<ProjectsEntity> projectsNames(String headid) {
	
		HeadsEntity h=headsDao.findByHdId(headid);
		return projectsDao.findByheadsentity(h);
	}
}
