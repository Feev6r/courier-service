package dev.ferv.courier_service.application.exeptionHandler;

public enum ErrorResponse {

    CODE_NOT_VALID("The code is not valid"),
    EXPIRED_CODE("The code is expired");

    private String message;

    ErrorResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
