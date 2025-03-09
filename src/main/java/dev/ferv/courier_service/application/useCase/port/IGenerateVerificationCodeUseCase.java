package dev.ferv.courier_service.application.useCase.port;

import dev.ferv.courier_service.application.dto.request.SmsRequest;

public interface IGenerateVerificationCodeUseCase {
    void generateAndSendCode(SmsRequest smsRequest);
    void verifyCode(String phoneNumber, String code);
}
