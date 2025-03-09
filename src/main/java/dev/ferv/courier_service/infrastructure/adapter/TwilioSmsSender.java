package dev.ferv.courier_service.infrastructure.adapter;

import org.springframework.stereotype.Component;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import dev.ferv.courier_service.domain.model.SmsModel;
import dev.ferv.courier_service.domain.port.SmsSenderPort;
import dev.ferv.courier_service.infrastructure.configuration.twilio.TwilioConfiguration;

@Component
public class TwilioSmsSender implements SmsSenderPort{

    private final TwilioConfiguration twilioConfiguration;

    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsModel smsRequest) {

        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = smsRequest.getMessage();

        MessageCreator creator = Message.creator(to,from,message);
        creator.create();
    }

}
