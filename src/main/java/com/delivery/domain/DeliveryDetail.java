package com.delivery.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DELIVERY_DETAIL_TB")
@Data
public class DeliveryDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DELIVERYDETAIL")
	@SequenceGenerator(name = "SEQ_DELIVERYDETAIL", allocationSize = 1)
	private Long id;

	@Column(name = "START_TIME")
	private LocalDateTime startTime;

	@Column(name = "END_TIME")
	private LocalDateTime endTime;

	@Column(name = "DELIVERY_MODE")
	@Enumerated(EnumType.STRING)
	private DeliveryMode deliveryMode;

}
