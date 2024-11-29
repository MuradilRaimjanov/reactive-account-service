package com.example.account.util;

import com.example.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class GenerateAccountNumber {

    private final AccountRepository accountRepository;

    private static final int ACCOUNT_NUMBER_LENGTH = 16;

    public Mono<String> generateAccountNumber() {
        return Mono.defer(() -> {
            String accountNumber = generateRandomAccountNumber();
            return isAccountNumberExists(accountNumber)
                    .flatMap(exists -> exists ? generateAccountNumber() : Mono.just(accountNumber));
        });
    }

    private String generateRandomAccountNumber() {
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            accountNumber.append(rand.nextInt(10));
        }
        return accountNumber.toString();
    }

    private Mono<Boolean> isAccountNumberExists(String uniqAccountNumber) {
        return accountRepository.existsAccountByAccountNumber(uniqAccountNumber);
    }
}
