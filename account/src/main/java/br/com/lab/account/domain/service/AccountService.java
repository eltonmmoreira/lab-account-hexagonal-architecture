package br.com.lab.account.domain.service;

import br.com.lab.account.domain.model.Account;

public interface AccountService {

    Account find(Long accountId);

    void debit(Long accountId, Double valueOfDebit);

}
