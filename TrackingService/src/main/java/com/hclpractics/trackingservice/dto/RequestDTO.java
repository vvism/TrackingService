package com.hclpractics.trackingservice.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

	@NotNull(message = "Please enter a valid Tracking ID")
	@Min(value=1, message = "Tracking Id should not be greater 8 digit and less than 9 digit")
	@Max(value=1000, message = "Tracking Id should not be greater 8 digit and less than 9 digit")
	private Integer trackingNumber;
}
