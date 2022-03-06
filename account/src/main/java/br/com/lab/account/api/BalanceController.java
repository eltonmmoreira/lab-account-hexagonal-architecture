package br.com.lab.account.api;

import br.com.lab.account.application.AccountApplication;
import br.com.lab.account.application.dto.response.AccountBalanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class BalanceController {

    private final AccountApplication accountApplication;

    public BalanceController(AccountApplication accountApplication) {
        this.accountApplication = accountApplication;
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalanceResponse> balance(@PathVariable long accountId) {
        return ResponseEntity.ok(accountApplication.getBalance(accountId));
    }
}
