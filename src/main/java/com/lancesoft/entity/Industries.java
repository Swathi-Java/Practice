package com.lancesoft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lancesoft.idgenerator.CustomIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Industries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "IND_id")
	@GenericGenerator(name = "IND_id",strategy = "com.lancesoft.idgenerator.CustomIdGenerator",parameters = {
			@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value="IND"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value ="%03d")
	})
private String industriesid;
private String industries;

}
