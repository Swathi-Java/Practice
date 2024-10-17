package com.lancesoft.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lancesoft.idgenerator.CustomIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="projects")
@AllArgsConstructor
@NoArgsConstructor
public class ProjectsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "project_id")
	@GenericGenerator(name = "project_id",strategy = "com.lancesoft.idgenerator.CustomIdGenerator",parameters = {
			@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value="proj"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value ="%01d")
	})
   private String proj_id;
   private String projects;
   @JsonIgnore
   @Lob
   private byte[] Whitepaper;
   @JsonIgnore
   @Lob
   private byte[] caseStudy;
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="technologyid")
   private Technologies technologies;
   private String status;
   @OneToOne
   private HeadsEntity headsentity;
}
