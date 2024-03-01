package com.delivery.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.domain.DeliveryMode;
import com.delivery.dto.DeliveryDetailDTO;
import com.delivery.events.KafkaProducer;
import com.delivery.service.DeliveryDetailService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class DeliveryController {
	
	@Autowired
	private DeliveryDetailService deliveryDetailService;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Value("${spring.kafka.kafka-producer-enabled}")
	private boolean kafkaEnbaled;

	
	@GetMapping("/delivery/{id}")
	public ResponseEntity<EntityModel<DeliveryDetailDTO>> getDeliveryDetailById(@PathVariable Long id) {
		DeliveryDetailDTO deliveryDetailDTO = deliveryDetailService.getDeliveryDetail(id);
		if (deliveryDetailDTO.getId() != null) {
			EntityModel<DeliveryDetailDTO> deliveryDetailModel = EntityModel.of(deliveryDetailDTO);
			deliveryDetailModel.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(DeliveryController.class).getDeliveryDetailById(id))
					.withSelfRel());
			return ResponseEntity.ok(deliveryDetailModel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
    @GetMapping("/delivery")
    public ResponseEntity<Page<DeliveryDetailDTO>> getAllDeliveryDetails(Pageable pageable) {
		log.debug("REST request to get page of delivery : {}", pageable);
		Page<DeliveryDetailDTO> pageDeliveryDetail = deliveryDetailService.getAllDeliveryDetail(pageable);
		return new ResponseEntity<>(pageDeliveryDetail, HttpStatus.OK);

    }
    
    
    @PostMapping("/delivery/reserve")
    public ResponseEntity<DeliveryDetailDTO> reserveDelivery(@Valid @RequestBody DeliveryDetailDTO deliveryDetailDTO) {
    	log.debug("REST request to save delivery detail : {}", deliveryDetailDTO);
    	deliveryDetailDTO = deliveryDetailService.createDeliveryDetail(deliveryDetailDTO);
        if(kafkaEnbaled) {
    	    kafkaProducer.sendMessage("delivery-app-topic", deliveryDetailDTO.toString());
        }
    	return new ResponseEntity<>(deliveryDetailDTO, HttpStatus.CREATED);
    }
    
    @GetMapping("/delivery-modes")
    public ResponseEntity<List<DeliveryMode>> getDeliveryModes() {
		log.debug("REST request to get all delivery modes");
        List<DeliveryMode> allDeliveryModes = deliveryDetailService.getAllDeliveryModes();
		return new ResponseEntity<>(allDeliveryModes, HttpStatus.OK);
    }
    
    
}