package com.bank.DAO;

public class AuthorizationFailureException extends Exception {
    final private String message;

    public AuthorizationFailureException(String message) {
        super(message);
        this.message = message;
    }

    public AuthorizationFailureException() {
        super("Podano błędne dane logowania");
        this.message = "Podano błędne dane logowania";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
