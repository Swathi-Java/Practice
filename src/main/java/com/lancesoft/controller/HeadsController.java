package com.lancesoft.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lancesoft.entity.HeadsEntity;
import com.lancesoft.service.HeadService;
import com.lancesoft.service.HeadsServiceImpl;
@CrossOrigin("*")
@RestController
public class HeadsController {
	@Autowired
	HeadsServiceImpl headsServiceImpl;
	
	@PostMapping("/addheads")
   public HeadsEntity addheads(@RequestParam String headsdetails,MultipartFile file) throws IOException
   {
		ObjectMapper objectMapper=new ObjectMapper();
		HeadsEntity headsEntity=objectMapper.readValue(headsdetails,HeadsEntity.class);
	   return headsServiceImpl.saveHeads(headsEntity,file);
   }
	@GetMapping("/AllManagers")
	public List<HeadsEntity> getAllManagers()
	{
		return headsServiceImpl.getAllHeads();
	}
	@PostMapping("/Managers")
	public HeadsEntity getManager(@RequestParam String hdId)
	{
		return headsServiceImpl.getheads(hdId);
	}
	@GetMapping("/getimage")
	public ResponseEntity<byte[]> managerimage(@RequestParam String name) {
		return headsServiceImpl.images(name);
	}
}
