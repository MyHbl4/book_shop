package com.moon.senla.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        LOGGER.error("Request " + request.getRequestURL() + " Threw an exception", ex);
        return "error";
    }
}
