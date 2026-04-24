package com.ankitrajlogin.jobportal.Exception;


import com.ankitrajlogin.jobportal.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception , WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage() , LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto , HttpStatus.INTERNAL_SERVER_ERROR) ;

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleArgumentNotValidException(MethodArgumentNotValidException exception , WebRequest webRequest){

        Map<String,String> errors = new HashMap<>() ;

        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors() ;

        fieldErrorList.forEach(error -> errors.put(error.getField() , error.getDefaultMessage()));

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false) , HttpStatus.BAD_REQUEST ,
                errors.toString() , LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto , HttpStatus.BAD_REQUEST) ;

    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>>HandlerMethodValidationException(HandlerMethodValidationException exception) {
        Map<String, String> errors = new HashMap<>() ;
        List<ParameterValidationResult> results = exception.getParameterValidationResults();
        results.forEach(result -> {
            String paramName = result.getMethodParameter().getParameterName();

            // for each paramter , there can be multiple error message
            // Combine all messages into a single comma-separated string
            String combinedMessages = result.getResolvableErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage()) // extract each message
                    .collect(Collectors.joining(","));  // join messages

            errors.put(paramName, combinedMessages);
        }) ;

            return ResponseEntity.badRequest().body(errors);
        }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseDto> handleNullException(Exception exception , WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,
                "A NullpointerException occured due to: " + exception.getMessage() , LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto , HttpStatus.INTERNAL_SERVER_ERROR) ;

    }



}
