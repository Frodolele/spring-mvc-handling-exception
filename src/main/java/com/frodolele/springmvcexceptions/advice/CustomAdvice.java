package com.frodolele.springmvcexceptions.advice;

import com.frodolele.springmvcexceptions.annotation.CustomExceptionHandler;
import com.frodolele.springmvcexceptions.dto.Response;
import com.frodolele.springmvcexceptions.exception.BusinessException;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice(annotations = CustomExceptionHandler.class)
public class CustomAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> handleException(BusinessException e) {
        val message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        val response = new Response(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
