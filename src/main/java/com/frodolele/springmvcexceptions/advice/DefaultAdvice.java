package com.frodolele.springmvcexceptions.advice;

import com.frodolele.springmvcexceptions.dto.Response;
import com.frodolele.springmvcexceptions.exception.BusinessException;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> handleException(BusinessException e) {
        val response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
