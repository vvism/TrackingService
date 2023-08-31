package com.hclpractics.trackingservice.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hclpractics.trackingservice.dto.RequestDTO;
import com.hclpractics.trackingservice.dto.ResponseDTO;
import com.hclpractics.trackingservice.model.TrackerModel;
import com.hclpractics.trackingservice.service.TrackingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tracking")
public class TrackingEndpoint {

	@Autowired
	private TrackingService service;
	
	
	@GetMapping(value = "/pageLaunch")
	public String launchTrackingPage() {
		
		return "index";
	}
	@PostMapping(value = "/getDetails")
	public ResponseEntity<Object>  getDetails(@RequestBody @Valid  RequestDTO requestDTO) {
		
		ResponseDTO responseDTO  = service.getTrackingDetails(requestDTO);
		
		return new ResponseEntity<Object>(responseDTO , HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object>  getDetails(@RequestBody @Valid  TrackerModel model) {
		
		service.add(model);
		
		return new ResponseEntity<Object>(model , HttpStatus.ACCEPTED);
	}
}
