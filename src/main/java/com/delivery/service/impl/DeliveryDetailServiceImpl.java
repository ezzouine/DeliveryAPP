package com.delivery.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delivery.domain.DeliveryDetail;
import com.delivery.domain.DeliveryMode;
import com.delivery.dto.DeliveryDetailDTO;
import com.delivery.dto.mapper.DeliveryDetailMapper;
import com.delivery.repository.DeliveryDetailRepository;
import com.delivery.service.DeliveryDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryDetailServiceImpl implements DeliveryDetailService {

	private final DeliveryDetailRepository deliveryDetailRepository;

	private final DeliveryDetailMapper deliveryDetailMapper;

	
	@Override
	public DeliveryDetailDTO createDeliveryDetail(DeliveryDetailDTO deliveryDetailDTO) {
		log.debug("Request to save delivery : {}", deliveryDetailDTO);
		return deliveryDetailMapper.toDto(deliveryDetailRepository.save(deliveryDetailMapper.toEntity(deliveryDetailDTO)));
	}

	
	@Override
	public Page<DeliveryDetailDTO> getAllDeliveryDetail(Pageable pageable) {
		log.debug("Request to get all delivery details");
		return deliveryDetailRepository.findAll(pageable).map(deliveryDetailMapper::toDto);

	}

	
	@Override
	public DeliveryDetailDTO getDeliveryDetail(Long id) {
		log.debug("Request to get delivery : {}", id);
		return deliveryDetailMapper.toDto(deliveryDetailRepository.findById(id).orElse(new DeliveryDetail()));
	}


	@Override
	public List<DeliveryMode> getAllDeliveryModes() {
		log.debug("Request to get all delivery modes");
		return List.of(DeliveryMode.values());
	}


	
}
