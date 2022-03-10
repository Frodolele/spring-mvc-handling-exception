package com.frodolele.springmvcexceptions.controller;

import com.frodolele.springmvcexceptions.annotation.CustomExceptionHandler;
import com.frodolele.springmvcexceptions.dto.Response;
import com.frodolele.springmvcexceptions.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CustomExceptionHandler
public class CustomAdviceHandlerController {

    @GetMapping(value = "testCustomAdviceHandler", produces = APPLICATION_JSON_VALUE)
    public Response testCustomAdviceHandler(@RequestParam(required = false, defaultValue = "false") boolean exception) throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in method testCustomAdviceHandler");
        }

        return new Response("OK");
    }
}
