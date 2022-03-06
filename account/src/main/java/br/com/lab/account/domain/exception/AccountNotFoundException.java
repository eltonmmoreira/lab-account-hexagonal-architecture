package br.com.lab.account.domain.exception;

import lombok.Getter;

public class AccountNotFoundException extends RuntimeException {

    @Getter
    private String description;

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }
}
