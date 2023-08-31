package com.hclpractics.trackingservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "Tracker")
public class TrackerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="trackingId")
	private int trackingId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderTrackingID")
	private List<OrderDetails> details;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "trackingStatusId") private List<TrackingStatus>
	 * trackingStatus;
	 */
}
