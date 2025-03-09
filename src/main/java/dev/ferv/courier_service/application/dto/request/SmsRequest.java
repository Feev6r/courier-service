package dev.ferv.courier_service.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SmsRequest {

    @NotBlank
    private final String phoneNumber;
    @NotBlank
    private final String message;
    
    public SmsRequest(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
    
}
