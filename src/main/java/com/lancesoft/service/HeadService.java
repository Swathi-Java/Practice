package com.lancesoft.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lancesoft.entity.HeadsEntity;

public interface HeadService {
 public HeadsEntity saveHeads(HeadsEntity headsEntity,MultipartFile file) throws IOException;
 public List<HeadsEntity> getAllHeads();
 public HeadsEntity getheads(String hdId);
 public ResponseEntity<byte[]>images(String name);
}
