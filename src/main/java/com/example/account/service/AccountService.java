package com.example.account.service;

import com.example.account.clients.ClientOpenFeign;
import com.example.account.config.WebClientConfig;
import com.example.account.dto.request.AccountRequestDto;
import com.example.account.mappers.model.AccountMapper;
import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import com.example.account.util.GenerateAccountNumber;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final GenerateAccountNumber generateAccountNumber;
    private final WebClient webClient;
    private final AccountMapper accountMapper;

    public Mono<Account> create(AccountRequestDto accountDto) {

        return webClient.get()
                .uri("/exist/{id}", accountDto.getClientId())
                .retrieve()
                .toBodilessEntity()
                .then(generateAccountNumber.generateAccountNumber()
                        .flatMap(accountNumber -> {
                            Account account = accountMapper.dtoToEntity(accountDto);
                            account.setCreationDate(LocalDate.now());
                            account.setAccountNumber(accountNumber);
                            return accountRepository.save(account);
                        }));
    }

    public Mono<Account> update(Long id, Account account) {
        return accountRepository.findById(id)
                .flatMap(exAccount -> {
                    exAccount.setAccountType(account.getAccountType());
                    exAccount.setStatus(account.getStatus());
                    return accountRepository.save(exAccount);
                });
    }

    public Flux<Account> findAll() {
        return accountRepository.findAll();
    }

    public Mono<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return accountRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return accountRepository.deleteAll();
    }
}
