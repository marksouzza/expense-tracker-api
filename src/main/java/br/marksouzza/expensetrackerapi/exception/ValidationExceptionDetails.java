package br.marksouzza.expensetrackerapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationExceptionDetails {
    private String field;
    private String error;
}
