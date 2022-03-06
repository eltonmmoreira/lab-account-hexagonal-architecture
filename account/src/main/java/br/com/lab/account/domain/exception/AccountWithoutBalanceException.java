package br.com.lab.account.domain.exception;

import lombok.Getter;

public class AccountWithoutBalanceException extends RuntimeException {

    @Getter
    private String description;

    public AccountWithoutBalanceException() {
        super();
    }

    public AccountWithoutBalanceException(String message, String description) {
        super(message);
        this.description = description;
    }
}
