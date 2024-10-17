package com.lancesoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lancesoft.entity.Manager;
import com.lancesoft.entity.Technologies;
import com.lancesoft.entity.TechnologyResponse;

@Service
public interface TechnologiesService  {
	 public Technologies saveTechnologies(Technologies Technologies);
	 public List<Technologies>  getAllTechnologies();
	 public List<Manager> getman(String technologies);
	 public List<TechnologyResponse> techdetails();
}
