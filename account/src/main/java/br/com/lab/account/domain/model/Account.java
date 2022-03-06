package br.com.lab.account.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person customer;

    private Double balance;

    public boolean debit(Double valueOfDebit) {
        if (getBalance() < valueOfDebit) {
            return false;
        }

        var debitedAmount = getBalance() - valueOfDebit;
        this.setBalance(debitedAmount);
        return true;
    }
}
