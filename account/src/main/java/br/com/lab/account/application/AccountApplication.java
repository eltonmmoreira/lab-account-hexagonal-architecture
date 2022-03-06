package br.com.lab.account.application;

import br.com.lab.account.application.dto.request.DebitAccountRequest;
import br.com.lab.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.account.application.dto.response.DebitAccountResponse;

public interface AccountApplication {

    AccountBalanceResponse getBalance(Long accountId);

    DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest);

}
