package com.hclpractics.trackingservice.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "OrderDetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private int orderId;
	
	@Column(name = "deliveryDate")
	private LocalDate deliveryDate;
	
	@Column(name = "itemCatagory")
	private String itemCatagory;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trackingStatusId")
	private TrackingStatus trackingStatus;

}
