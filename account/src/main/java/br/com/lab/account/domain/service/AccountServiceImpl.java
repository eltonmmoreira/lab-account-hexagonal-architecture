package br.com.lab.account.domain.service;

import br.com.lab.account.domain.exception.AccountNotFoundException;
import br.com.lab.account.domain.exception.AccountWithoutBalanceException;
import br.com.lab.account.domain.model.Account;
import br.com.lab.account.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Value("${lab.account.exceptions.account-dont-exists-message}")
    private String messageExceptionAccountNotFound;

    @Value("${lab.account.exceptions.account-dont-exists-description}")
    private String descriptionExceptionAccountNotFound;

    @Value("${lab.account.exceptions.account-without-balance-message}")
    private String messageExceptionAccountWithoutBalance;

    @Value("${lab.account.exceptions.account-without-balance-description}")
    private String descriptionExceptionAccountWithoutBalance;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account find(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() ->
                new AccountNotFoundException(
                        messageExceptionAccountNotFound,
                        descriptionExceptionAccountNotFound)
        );
    }

    @Override
    public void debit(Long accountId, Double valueOfDebit) {
        var account = find(accountId);
        var debited = account.debit(valueOfDebit);

        if (!debited) {
            throw new AccountWithoutBalanceException(
                    messageExceptionAccountWithoutBalance,
                    descriptionExceptionAccountWithoutBalance
            );
        }

        accountRepository.save(account);
    }
}
