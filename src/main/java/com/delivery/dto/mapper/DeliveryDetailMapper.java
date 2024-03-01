package com.delivery.dto.mapper;

import org.mapstruct.Mapper;

import com.delivery.domain.DeliveryDetail;
import com.delivery.dto.DeliveryDetailDTO;

@Mapper(componentModel = "spring")
public interface DeliveryDetailMapper extends EntityMapper<DeliveryDetailDTO, DeliveryDetail> {

}
