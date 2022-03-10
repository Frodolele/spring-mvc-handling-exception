package com.frodolele.springmvcexceptions.controller;

import com.frodolele.springmvcexceptions.dto.Response;
import com.frodolele.springmvcexceptions.exception.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ResponseStatusHandlerController {

    @GetMapping(value = "/testResponseStatusHandler", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusHandler(@RequestParam(required = false, defaultValue = "false") boolean exception) throws ServiceException {
        if (exception) {
            throw new ServiceException("ServiceException in method testResponseStatusHandler");
        }

        return new Response("OK");
    }
}
