package com.delivery.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.delivery.domain.DeliveryMode;
import com.delivery.util.ErrorMessages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeliveryDetailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = ErrorMessages.STARTTIME_REQUIRED_ERROR_MESSAGE)
	private LocalDateTime startTime;

	@NotNull(message = ErrorMessages.ENDTIME_REQUIRED_ERROR_MESSAGE)
	private LocalDateTime endTime;

	@NotNull(message = ErrorMessages.DELIVERY_MODE_REQUIRED_ERROR_MESSAGE)
	private DeliveryMode deliveryMode;

}
