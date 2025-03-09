package dev.ferv.courier_service.infrastructure.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ferv.courier_service.domain.port.RedisStoragePort;
import dev.ferv.courier_service.domain.port.SmsSenderPort;
import dev.ferv.courier_service.domain.service.SmsCodeService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ServiceConfiguration {

    private final RedisStoragePort redisStoragePort;
    private final SmsSenderPort senderPort;

    @Bean
    SmsCodeService smsCodeService(){
        return new SmsCodeService(redisStoragePort, senderPort);
    }

}
