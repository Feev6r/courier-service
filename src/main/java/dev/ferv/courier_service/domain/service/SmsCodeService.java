package dev.ferv.courier_service.domain.service;

import java.util.Random;

import dev.ferv.courier_service.domain.exeptions.CodeNotValidExeption;
import dev.ferv.courier_service.domain.exeptions.ExpiredCodeExeption;
import dev.ferv.courier_service.domain.model.SmsModel;
import dev.ferv.courier_service.domain.port.RedisStoragePort;
import dev.ferv.courier_service.domain.port.SmsSenderPort;

public class SmsCodeService {

    private final RedisStoragePort redisStoragePort;
    private final SmsSenderPort senderPort;

    public SmsCodeService(RedisStoragePort redisStoragePort, SmsSenderPort senderPort) {
        this.redisStoragePort = redisStoragePort;
        this.senderPort = senderPort;
    }

    private String generateCode() {

        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    public void generateAndSendCode(SmsModel smsModel) {
        String code = generateCode();
        long ttlMinutes = 10;

        // Guardar el código
        redisStoragePort.saveCode(smsModel.getPhoneNumber(), code, ttlMinutes);

        // Enviar SMS
        senderPort.sendSms(new SmsModel(smsModel.getPhoneNumber(), smsModel.getMessage() + code));
    }

    public boolean verifyCode(String phoneNumber, String code) {
        String storedCode = redisStoragePort.getCode(phoneNumber);

        System.out.println(storedCode);

        if (storedCode == null) {
            throw new ExpiredCodeExeption();
        }


        boolean isValid = storedCode.equals(code);

        System.out.println(isValid);

        if (isValid) {
            redisStoragePort.deleteCode(phoneNumber);
        }
        else{
            throw new CodeNotValidExeption();
        }


        return isValid;
    }

}
