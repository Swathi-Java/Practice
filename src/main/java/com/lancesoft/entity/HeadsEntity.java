package com.lancesoft.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lancesoft.idgenerator.CustomIdGenerator;

import lombok.Data;

@Entity
@Table(name="Heads")
@Data
public class HeadsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_sql")
	@GenericGenerator(name = "user_sql",strategy = "com.lancesoft.idgenerator.CustomIdGenerator",parameters = {
			@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value="EMP"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value ="%03d")
	})
	private String hdId;
	private String headname;
	private String designation;
	private String mail;
	private String phoneNumber;
	@JsonIgnore
	@Lob
	private byte[] image;
		
	
	


}
