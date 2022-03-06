package br.com.lab.account.application.dto.response;

import lombok.Data;

@Data
public class DebitAccountResponse {
    private boolean debited;

    public DebitAccountResponse() {
    }

    public DebitAccountResponse(boolean debited) {
        this.debited = debited;
    }
}
