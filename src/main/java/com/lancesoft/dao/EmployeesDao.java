package com.lancesoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancesoft.entity.EmployeesEntity;
import com.lancesoft.entity.HeadsEntity;

public interface EmployeesDao extends JpaRepository<EmployeesEntity, String>{
     List<EmployeesEntity> findByTechnology(String technology);
     List<EmployeesEntity> findByProjects(String Projects);
     List<EmployeesEntity> findByManagerAndTechnology(HeadsEntity manager,String technology);
     List<EmployeesEntity> findByManagerAndTechnologyAndProjects(String manager,String technology,String projects);
     List<EmployeesEntity> findByName(String name);
     List<EmployeesEntity> findByManager(String manager);
}
