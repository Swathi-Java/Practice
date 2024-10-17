package com.lancesoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancesoft.entity.Technologies;

public interface TechnologiesDao extends JpaRepository<Technologies, String>{
 boolean existsBytechnologies(String technologies);
 Technologies findBytechnologies(String technologies);


 
}
