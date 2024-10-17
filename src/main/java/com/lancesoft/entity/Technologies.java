package com.lancesoft.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lancesoft.idgenerator.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="technologies")
public class Technologies {
 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_sql")
	@GenericGenerator(name = "user_sql",strategy = "com.lancesoft.idgenerator.CustomIdGenerator",parameters = {
			@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value="TEC"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value ="%03d")
	})
    private String tech_id;
    private String technologies;
    @ManyToMany
    private List<HeadsEntity> listOfManagers;
    
}
