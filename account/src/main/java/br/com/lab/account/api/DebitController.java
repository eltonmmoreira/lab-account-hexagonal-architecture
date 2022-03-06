package br.com.lab.account.api;

import br.com.lab.account.application.AccountApplication;
import br.com.lab.account.application.dto.request.DebitAccountRequest;
import br.com.lab.account.application.dto.response.DebitAccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class DebitController {

    private final AccountApplication accountApplication;

    public DebitController(AccountApplication accountApplication) {
        this.accountApplication = accountApplication;
    }

    @PostMapping("/{accountId}/debit")
    public ResponseEntity<DebitAccountResponse> balance(
            @PathVariable long accountId,
            @RequestBody DebitAccountRequest debitAccountRequest) {

        return ResponseEntity.ok(accountApplication.debit(accountId, debitAccountRequest));
    }
}
