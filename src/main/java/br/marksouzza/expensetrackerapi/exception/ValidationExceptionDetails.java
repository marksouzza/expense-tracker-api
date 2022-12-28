package br.marksouzza.expensetrackerapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ValidationExceptionDetails {
    private String filed;
    private String error;
}
