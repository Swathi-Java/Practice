package com.lancesoft.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lancesoft.dao.ProjectName;
import com.lancesoft.entity.EmployeeCount;
import com.lancesoft.entity.HeadsEntity;
import com.lancesoft.entity.Proj;
import com.lancesoft.entity.ProjectsEntity;

@Service
public interface ProjectsService {
  public ProjectsEntity saveverticals(ProjectsEntity projectsEntity, MultipartFile file, MultipartFile file1) throws IOException;
  public List<ProjectsEntity> allprojects(); 
 public HashSet<String> projectName(String technology,String manager,ProjectName projectName);
 public List<Proj> projectName1(String technology,String manager,Proj proj);
 public  ResponseEntity<byte []>  whitepaper(String projects);
 public ResponseEntity<byte[]> CaseStudy(String caseStudy);
 public List<ProjectsEntity> projectsNames(String headid);
}
