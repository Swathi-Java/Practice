package com.lancesoft.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.lancesoft.dao.HeadsDao;
import com.lancesoft.dao.TechnologiesDao;
import com.lancesoft.entity.HeadsEntity;

@Service
public class HeadsServiceImpl implements HeadService {
	@Autowired 
	 HeadsDao headsDao;
	@Autowired
	HttpServletResponse httpServletResponse;
@Autowired 
TechnologiesDao technologiesDao;
	@Override
	public HeadsEntity saveHeads(HeadsEntity headsEntity,MultipartFile file) throws IOException
	{
		headsEntity.setImage(file.getBytes());
		return headsDao.save(headsEntity);
	}

	@Override
	public List<HeadsEntity> getAllHeads() {
		
		return headsDao.findAll();
	}

	@Override
	public HeadsEntity getheads(String hdId) {
		
		return headsDao.findByHdId(hdId);
	}

	@Override
	public ResponseEntity<byte[]> images(String name) {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		httpServletResponse.setContentType("image/png");
		return new ResponseEntity<byte[]>(headsDao.findByHeadname(name).getImage(), headers,HttpStatus.OK);
		//return new ResponseEntity<byte[]>(headsDao.findByHeadname(name).getHeadname().get(0),headers,HttpStatus.OK);
	}
	

}
