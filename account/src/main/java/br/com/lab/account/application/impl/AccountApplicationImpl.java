package br.com.lab.account.application.impl;

import br.com.lab.account.application.AccountApplication;
import br.com.lab.account.application.dto.request.DebitAccountRequest;
import br.com.lab.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.account.application.dto.response.DebitAccountResponse;
import br.com.lab.account.domain.service.AccountService;
import org.springframework.stereotype.Component;

import static br.com.lab.account.application.adapter.AccountAdapter.toDtoBalance;

@Component
public class AccountApplicationImpl implements AccountApplication {

    private final AccountService accountService;

    public AccountApplicationImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public AccountBalanceResponse getBalance(Long accountId) {
        return toDtoBalance(accountService.find(accountId));
    }

    @Override
    public DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest) {
        accountService.debit(accountId, debitAccountRequest.getValueOfDebit());
        return new DebitAccountResponse(true);
    }
}
