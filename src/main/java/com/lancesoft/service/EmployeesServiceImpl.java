package com.lancesoft.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lancesoft.dao.EmployeesDao;
import com.lancesoft.dao.HeadsDao;
import com.lancesoft.entity.EmployeeCount;
import com.lancesoft.entity.EmployeeResponse;
import com.lancesoft.entity.EmployeesEntity;
import com.lancesoft.entity.HeadsEntity;
@Service
public class EmployeesServiceImpl implements EmployeesService{
	@Autowired
	EmployeesDao employeesDao;
	@Autowired
	HeadsDao headsDao;
	@Autowired
	HttpServletResponse httpServletResponse;
	@Override
	public EmployeesEntity saveemployees(EmployeesEntity employeesEntity ,MultipartFile file,HeadsEntity headsEntity) throws IOException {
		employeesEntity.setEmployimage(file.getBytes());
		HeadsEntity heads=headsDao.findByHdId(employeesEntity.getManager().getHdId());
		employeesEntity.setManager(heads);
		return employeesDao.save(employeesEntity);

	}

	@Override
	public List<EmployeeResponse> getemployee(String technology,String manager) {
		
		HeadsEntity heads=headsDao.findByHeadname(manager);
		List<EmployeesEntity>employeesEntities= employeesDao.findByManagerAndTechnology(heads,technology);
		List<EmployeeResponse> employ=new ArrayList<>();
		for(int i=0; i<employeesEntities.size();i++)
		{
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setName(employeesEntities.get(i).getName());
			employeeResponse.setDesignation(employeesEntities.get(i).getDesignation());
			employeeResponse.setEmployid(employeesEntities.get(i).getEmpid());
			employeeResponse.setMail(employeesEntities.get(i).getMail());
			employeeResponse.setManager(employeesEntities.get(i).getManager().getHeadname());
			employeeResponse.setManagermail(employeesEntities.get(i).getManager().getMail());
			employeeResponse.setProject(employeesEntities.get(i).getProjects());
			employeeResponse.setTechnology(employeesEntities.get(i).getTechnology());
			employ.add(employeeResponse);
		}
		return employ;
	}

	@Override
	public EmployeeCount getcount(String technology,String manager,EmployeeCount employeeCount) {
		int employeesCount=0;
		int projectCount=0;
		
		HashSet<String> projects=new HashSet<>();
		HeadsEntity heads=headsDao.findByHeadname(manager);
		List<EmployeesEntity> employe= employeesDao.findByManagerAndTechnology(heads, technology);
		for(EmployeesEntity employeesEntity:employe)
		{
			employeesCount++;
			if(projects.add(employeesEntity.getProjects()))
			{	
				projectCount++;
		     
			}
			
		}
		employeeCount.setEmployeeCount(employeesCount);
		employeeCount.setProjectCount(projectCount);
		return employeeCount ;
		
		
		
	}
	@Override
	public ResponseEntity<byte[]> gettimages(String name) {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		httpServletResponse.setContentType("image/png");
		return new ResponseEntity<byte[]>(employeesDao.findByName(name).get(0).getEmployimage(),headers,HttpStatus.OK);
	
	}
}
