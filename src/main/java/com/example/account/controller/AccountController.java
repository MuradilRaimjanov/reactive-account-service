package com.example.account.controller;

import com.example.account.clients.ClientOpenFeign;
import com.example.account.dto.request.AccountRequestDto;
import com.example.account.model.Account;
import com.example.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Mono<Account> create(@RequestBody AccountRequestDto accountDto) {
        return accountService.create(accountDto);
    }

    @PutMapping("/{id}")
    public Mono<Account> update(@PathVariable Long id, @RequestBody Account account) {
        return accountService.update(id, account);
    }
    @GetMapping("/{id}")
    public Mono<Account> findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @GetMapping
    public Flux<Account> findAll() {
        return accountService.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return accountService.deleteById(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAll() {
        return accountService.deleteAll();
    }
}
