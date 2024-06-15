package org.example.jpapractice.global.exception;


import lombok.Getter;
import org.example.jpapractice.global.response.DtoCustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@RestControllerAdvice
public class ExceprionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DtoCustomErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {

            DtoCustomErrorResponse response = new DtoCustomErrorResponse("400", "잘못된 요청입니다.");

            for(FieldError fieldError : e.getFieldErrors()) {
                response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return response;
        }
    }



