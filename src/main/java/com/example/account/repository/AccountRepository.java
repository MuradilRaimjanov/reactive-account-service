package com.example.account.repository;

import com.example.account.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {

    Mono<Boolean> existsAccountByAccountNumber(String accountNumber);
}
