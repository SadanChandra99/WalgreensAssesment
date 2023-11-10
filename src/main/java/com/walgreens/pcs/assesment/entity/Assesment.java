package com.walgreens.pcs.assesment.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Assesment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assesmentId;
	
	private String assesmentName;
	
	private String status;
	
	private LocalDate lastUpdateddate;
	
	private String lastUpdatedBy;
	
	
	

}
