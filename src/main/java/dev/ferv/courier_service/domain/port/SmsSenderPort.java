package dev.ferv.courier_service.domain.port;

import dev.ferv.courier_service.domain.model.SmsModel;

public interface SmsSenderPort {

    void sendSms(SmsModel smsRequest);
}
