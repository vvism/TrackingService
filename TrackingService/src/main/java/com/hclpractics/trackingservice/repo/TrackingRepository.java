package com.hclpractics.trackingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hclpractics.trackingservice.model.TrackerModel;

@Repository
public interface TrackingRepository extends JpaRepository<TrackerModel, Integer>{

	List<TrackerModel> findByTrackingId(Integer trackingId);
	
}
