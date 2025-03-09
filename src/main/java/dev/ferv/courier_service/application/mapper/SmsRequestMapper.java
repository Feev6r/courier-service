package dev.ferv.courier_service.application.mapper;

import org.mapstruct.Mapper;

import dev.ferv.courier_service.application.dto.request.SmsRequest;
import dev.ferv.courier_service.domain.model.SmsModel;

@Mapper(componentModel = "spring")
public interface SmsRequestMapper {

    SmsModel toModel(SmsRequest smsRequest);
}
