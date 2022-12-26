package br.marksouzza.expensetrackerapi.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
public class ValidationException {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationExceptionDetails> handle(MethodArgumentNotValidException exception) {

        List<ValidationExceptionDetails> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach( e ->{
            String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ValidationExceptionDetails error = new ValidationExceptionDetails(e.getField(), msg);
            errors.add(error);
        });
        return errors;
    }
    }

