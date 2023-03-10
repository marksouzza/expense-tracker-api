package br.marksouzza.expensetrackerapi.handler;

import br.marksouzza.expensetrackerapi.exception.BadRequestException;
import br.marksouzza.expensetrackerapi.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class BadRequestExceptionHandler {

        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<ExceptionDetails> handlerBadRequestException(BadRequestException bre) {
            return new ResponseEntity<>(
                    ExceptionDetails.builder()
                            .timestamp(LocalDateTime.now())
                            .status(HttpStatus.BAD_REQUEST.value())
                            .title("Bad Request Exception, check the documentation")
                            .details(bre.getMessage())
                            .developerMessage(bre.getClass().getName())
                            .build(), HttpStatus.BAD_REQUEST);
        }
    }
