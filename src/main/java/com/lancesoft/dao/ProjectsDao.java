package com.lancesoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancesoft.entity.HeadsEntity;
import com.lancesoft.entity.ProjectsEntity;
import com.lancesoft.entity.Technologies;

public interface ProjectsDao  extends JpaRepository<ProjectsEntity, String>{
   List<ProjectsEntity> findBytechnologies(Technologies technology);
   List<ProjectsEntity> findByheadsentity(HeadsEntity headsentity);
   List<ProjectsEntity> findByProjects(String projects);
  

	
   
}
