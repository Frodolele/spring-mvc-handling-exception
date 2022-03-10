package com.frodolele.springmvcexceptions.controller;

import com.frodolele.springmvcexceptions.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ResponseStatusExceptionHandlerController {

    @GetMapping(value = "/testResponseStatusExceptionHandler", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusExceptionHandler(@RequestParam(required = false, defaultValue = "false") boolean exception) {
        if (exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ResponseStatusException in method testResponseStatusExceptionHandler");
        }

        return new Response("OK");
    }
}
