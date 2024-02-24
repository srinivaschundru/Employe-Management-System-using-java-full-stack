package net.javaguides.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleError(WebRequest w,ResourceNotFoundException r){
        ErrorDetails e=new ErrorDetails(
                LocalDateTime.now(),
                r.getMessage(),
                w.getDescription(false),
                "User_ID not found"
        );
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
