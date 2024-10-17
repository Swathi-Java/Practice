package com.lancesoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancesoft.entity.HeadsEntity;

public interface HeadsDao extends JpaRepository<HeadsEntity,String> {
	HeadsEntity findByHeadname(String name);
	HeadsEntity findByHdId(String id);
	
	
  	
 
}
