package dev.ferv.courier_service.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ValidationResponse {

    private boolean isValid;
    private String message;
    private String errorCode;

}
