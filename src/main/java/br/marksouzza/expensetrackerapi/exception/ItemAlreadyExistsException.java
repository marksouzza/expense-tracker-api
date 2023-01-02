package br.marksouzza.expensetrackerapi.exception;

import java.io.Serial;

public class ItemAlreadyExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ItemAlreadyExistsException(String message){
        super(message);
    }
}
