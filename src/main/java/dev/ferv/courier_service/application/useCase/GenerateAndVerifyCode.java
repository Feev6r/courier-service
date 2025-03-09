package dev.ferv.courier_service.application.useCase;

import org.springframework.stereotype.Service;

import dev.ferv.courier_service.application.dto.request.SmsRequest;
import dev.ferv.courier_service.application.mapper.SmsRequestMapper;
import dev.ferv.courier_service.application.useCase.port.IGenerateVerificationCodeUseCase;
import dev.ferv.courier_service.domain.service.SmsCodeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenerateAndVerifyCode implements IGenerateVerificationCodeUseCase {
    
    private final SmsCodeService smsCodeService;
    private final SmsRequestMapper smsRequestMapper;

    @Override
    public void generateAndSendCode(SmsRequest smsRequest){
        smsCodeService.generateAndSendCode(smsRequestMapper.toModel(smsRequest));
    }

    @Override
    public void verifyCode(String phoneNumber, String code){
        smsCodeService.verifyCode(phoneNumber, code);
    }
}
