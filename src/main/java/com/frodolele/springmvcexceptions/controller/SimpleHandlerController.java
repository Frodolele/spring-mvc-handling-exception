package com.frodolele.springmvcexceptions.controller;

import com.frodolele.springmvcexceptions.dto.Response;
import com.frodolele.springmvcexceptions.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class SimpleHandlerController {

    @GetMapping(value = "/simpleHandler", produces = APPLICATION_JSON_VALUE)
    public Response testSimpleHandler(@RequestParam(required = false, defaultValue = "false") boolean exception) throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in method testSimpleHandler");
        }

        return new Response("OK");
    }

    @ExceptionHandler(BusinessException.class)
    public Response handleException(BusinessException e) {
        return new Response(e.getMessage());
    }
}
