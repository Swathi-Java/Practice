package com.lancesoft.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lancesoft.entity.EmployeeCount;
import com.lancesoft.entity.EmployeeResponse;
import com.lancesoft.entity.EmployeesEntity;
import com.lancesoft.entity.HeadsEntity;

@Service
public interface EmployeesService {
 public EmployeesEntity saveemployees( EmployeesEntity employeesEntity,MultipartFile file,HeadsEntity headsEntity) throws IOException;
 public List<EmployeeResponse> getemployee(String technology,String manager);
 public EmployeeCount getcount(String technology,String manager,EmployeeCount employeeCount);
 public ResponseEntity<byte[]> gettimages(String name);
}
