package com.lancesoft.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lancesoft.idgenerator.CustomIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Emp_id")
	@GenericGenerator(name = "Emp_id",strategy = "com.lancesoft.idgenerator.CustomIdGenerator",parameters = {
			@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value="EMP"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value ="%03d")
	})
	private String empid;
	private String name;
	private String designation;
	private String mail;
	@JoinColumn(name="managerEntity")
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private HeadsEntity manager;
	private String projects;
	private String technology;
	@Lob
	private byte[] employimage;

}
