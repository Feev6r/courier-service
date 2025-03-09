package dev.ferv.courier_service.domain.model;

public class SmsModel {
    private final String phoneNumber;
    private final String message;

    public SmsModel(String phoneNumber, String message) {
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
