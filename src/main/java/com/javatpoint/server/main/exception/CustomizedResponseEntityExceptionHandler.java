/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.server.main.exception;

import com.javatpoint.server.main.user.UserNotFoundException;
import java.util.Date;  
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;  
import org.springframework.web.bind.annotation.ExceptionHandler;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.context.request.WebRequest;  
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;  
//defining exception handling for all the exceptions  
@ControllerAdvice  
@RestController  
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler  
{  
@ExceptionHandler(Exception.class)  
//override method of ResponseEntityExceptionHandler class  
public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)  
{  
//creating exception response structure  
ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));  
//returning exception structure and specific status   
return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);  
}  

@ExceptionHandler(UserNotFoundException.class)  
//override method of ResponseEntityExceptionHandler class  
public final ResponseEntity<Object> handleUserNotFoundExceptionExceptions(UserNotFoundException ex, WebRequest request)  
{  
//creating exception response structure  
ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));  
//returning exception structure and specific status   
return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);  
}

@Override  
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)   
{  
ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),/*ex.getMessage()*/"Validation failed", ex.getBindingResult().toString());  
//returning exception structure and specific status   
return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);  
}  
}  