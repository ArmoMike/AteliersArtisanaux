package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GetMapping("/error")
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex, Model model, WebRequest request) {
        // You can customize the error handling logic here
        // For example, log the exception or redirect to a specific error page
        model.addAttribute("error", ex.getMessage());
        return "error";  // Create an error.html template
    }
}

