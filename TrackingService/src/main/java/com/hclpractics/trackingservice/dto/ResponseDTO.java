package com.hclpractics.trackingservice.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.hclpractics.trackingservice.model.TrackerModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

	private  Map<String, String> messages;
	private  HttpStatus httpStatus;
	private  LocalDateTime time;
	private  List<TrackerModel> data;
	
}
