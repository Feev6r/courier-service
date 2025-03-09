package dev.ferv.courier_service.infrastructure.configuration.twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

    private final TwilioConfiguration twilioConfiguration;

    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
            twilioConfiguration.getAccountSid(),
            twilioConfiguration.getAuthToken()
        );
        
        LOGGER.info("SID: {}", this.twilioConfiguration.getAccountSid());
    }
 

}
