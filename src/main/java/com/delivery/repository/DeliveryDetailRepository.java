package com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.delivery.domain.DeliveryDetail;

@Repository
public interface DeliveryDetailRepository
		extends JpaRepository<DeliveryDetail, Long>, JpaSpecificationExecutor<DeliveryDetail> {

}
