package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.domain.DeliveryMode;
import com.delivery.dto.DeliveryDetailDTO;

public interface DeliveryDetailService {


	DeliveryDetailDTO createDeliveryDetail(DeliveryDetailDTO deliveryDetailDTO);

	
	Page<DeliveryDetailDTO> getAllDeliveryDetail(Pageable pageable);

	
	DeliveryDetailDTO getDeliveryDetail(Long id);


	List<DeliveryMode> getAllDeliveryModes();
}
