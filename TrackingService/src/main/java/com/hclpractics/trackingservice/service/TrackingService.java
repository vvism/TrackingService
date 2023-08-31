package com.hclpractics.trackingservice.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hclpractics.trackingservice.dto.RequestDTO;
import com.hclpractics.trackingservice.dto.ResponseDTO;
import com.hclpractics.trackingservice.exception.NoSuchTrackingNumberExistsException;
import com.hclpractics.trackingservice.model.TrackerModel;
import com.hclpractics.trackingservice.repo.TrackingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackingService {

	@Autowired
	private TrackingRepository trackingRepository;

	@Autowired
	private ResponseDTO responseDTO;

	public ResponseDTO getTrackingDetails(RequestDTO requestDTO) {

		System.out.println("vlue "+trackingRepository.findAll());
		List<TrackerModel> trackerList = trackingRepository.findByTrackingId(requestDTO.getTrackingNumber());

		log.info("size of list "+trackerList.size());
		
		
		if (trackerList.size() != 0 ) {
			Map<String, String> errorMessage = new HashMap<String, String>();

			responseDTO.setData(trackerList);
			responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
			responseDTO.setTime(LocalDateTime.now());
			responseDTO.setMessages(errorMessage);

			return responseDTO;
        }
        else {
            throw new NoSuchTrackingNumberExistsException(
                "Tracking Number Not exists!!");
        }
		
	}

	public void add(TrackerModel model) {

		trackingRepository.save(model);
	}

}
