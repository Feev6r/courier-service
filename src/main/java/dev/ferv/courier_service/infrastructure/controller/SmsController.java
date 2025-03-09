package dev.ferv.courier_service.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ferv.courier_service.application.dto.request.SmsRequest;
import dev.ferv.courier_service.application.dto.response.ValidationResponse;
import dev.ferv.courier_service.application.useCase.port.IGenerateVerificationCodeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("sms")
@RequiredArgsConstructor
@Validated
public class SmsController {

    private final IGenerateVerificationCodeUseCase generateVerificationCodeUseCase;

        
    @Operation(
        description = "generates and sends a sms pin to the client",
        summary = "Pin generation",
        responses = {
            @ApiResponse(
                description = "Succes",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Unauthorized",
                responseCode = "403"
            )
        }
    )
    @PostMapping("/")
    public ResponseEntity<Void> sendSms(@Valid @RequestBody SmsRequest smsRequest){
        generateVerificationCodeUseCase.generateAndSendCode(smsRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    
    @Operation(
        description = "verfies the pin code",
        summary = "Pin verifcation",
        responses = {
            @ApiResponse(
                description = "Succes",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Unauthorized",
                responseCode = "403"
            )
        }
    )
    @GetMapping("verify/{phoneNumber}/{code}")
    public ResponseEntity<ValidationResponse> verifyCode(@PathVariable String phoneNumber, @PathVariable String code) {
        generateVerificationCodeUseCase.verifyCode(phoneNumber, code);

        ValidationResponse validationResponse = new ValidationResponse(true, phoneNumber, null);
        return ResponseEntity.ok(validationResponse);

    }
    
}
