package com.hclpractics.trackingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrackingStatus")
public class TrackingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tsId")
	private int tsId; 
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "cancleOrder")
	private String cancleOrder;
	
	
}
