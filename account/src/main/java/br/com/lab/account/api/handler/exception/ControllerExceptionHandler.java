package br.com.lab.account.api.handler.exception;

import br.com.lab.account.application.dto.response.ErrorMessageResponse;
import br.com.lab.account.domain.exception.AccountNotFoundException;
import br.com.lab.account.domain.exception.AccountWithoutBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String DEFAULT_MESSAGE_ERROR = "Não foi possível processar sua requisição";

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> accountNotFindException(AccountNotFoundException accountNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessageResponse(
                        HttpStatus.NOT_FOUND.value(),
                        LocalDateTime.now(),
                        accountNotFoundException.getMessage(),
                        accountNotFoundException.getDescription()
                )
        );
    }

    @ExceptionHandler(AccountWithoutBalanceException.class)
    public ResponseEntity<ErrorMessageResponse> withoutBalanceException(AccountWithoutBalanceException accountWithoutBalanceException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessageResponse(
                        HttpStatus.NOT_FOUND.value(),
                        LocalDateTime.now(),
                        accountWithoutBalanceException.getMessage(),
                        accountWithoutBalanceException.getDescription()
                )
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessageResponse> generalError(RuntimeException runtimeException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessageResponse(
                        HttpStatus.NOT_FOUND.value(),
                        LocalDateTime.now(),
                        runtimeException.getMessage(),
                        DEFAULT_MESSAGE_ERROR
                )
        );
    }

}
