package com.lancesoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancesoft.dao.EmployeesDao;
import com.lancesoft.dao.HeadsDao;
import com.lancesoft.dao.TechnologiesDao;
import com.lancesoft.entity.EmployeesEntity;
import com.lancesoft.entity.HeadsEntity;
import com.lancesoft.entity.Manager;
import com.lancesoft.entity.Technologies;
import com.lancesoft.entity.TechnologyResponse;
import com.lancesoft.exceptions.CustomException;

@Service
public class TechnologiesServiceImpl implements TechnologiesService {
	@Autowired
	TechnologiesDao technologiesDao;
	@Autowired
	HeadsDao headsDao;
	@Autowired
	EmployeesDao employeesDao;

	@Override
	public Technologies saveTechnologies(Technologies technology) {

		for (int i = 0; i < technology.getListOfManagers().size(); i++) {
			String managerId = technology.getListOfManagers().get(i).getHdId();
			HeadsEntity manEntity = headsDao.findByHdId(managerId);
			technology.getListOfManagers().set(i, manEntity);
		}

		return technologiesDao.save(technology);
	}

	@Override
	public List<Technologies> getAllTechnologies() {

		return technologiesDao.findAll();
	}

	@Override
	public List<Manager> getman(String technologies) {
		

		 Technologies technlgy=technologiesDao.findBytechnologies(technologies);
		List<HeadsEntity>listOfMangers= technlgy.getListOfManagers();
		List<Manager> managersPerTech=new ArrayList<>();
		for(HeadsEntity headsEntity:listOfMangers)
		{
			Manager manager=new Manager();
			manager.setName(headsEntity.getHeadname());
			manager.setPhoneNumber(headsEntity.getPhoneNumber());
			manager.setTechnology(technlgy.getTechnologies());
			manager.setDesignation(headsEntity.getDesignation());
			manager.setId(headsEntity.getHdId());
			manager.setMail(headsEntity.getMail());
			managersPerTech.add(manager);
			
		}
		 return managersPerTech;
	}
	@Override
	public List<TechnologyResponse> techdetails() 
	{
		List<Technologies> technologies2=technologiesDao.findAll();
		List<TechnologyResponse>techResponse=new ArrayList<>();
		for(int i=0;i<technologies2.size();i++)
		{
			List<EmployeesEntity>e=employeesDao.findByTechnology(technologies2.get(i).getTechnologies());
			TechnologyResponse technologyResponse=new TechnologyResponse();
			technologyResponse.setTechnology(technologies2.get(i).getTechnologies());
			technologyResponse.setTechcount(e.size());techResponse.add(technologyResponse);
	}
	return techResponse;
	}
}
