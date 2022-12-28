package br.marksouzza.expensetrackerapi.handler;
import br.marksouzza.expensetrackerapi.exception.ResourceNotFoundException;
import br.marksouzza.expensetrackerapi.exception.ResourceNotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundExceptionDetails> handlerResourceNotFound(ResourceNotFoundException bre) {
        return new ResponseEntity<>(
                ResourceNotFoundExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Resource not found, check the documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);
    }
}
