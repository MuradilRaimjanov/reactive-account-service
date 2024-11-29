package com.example.account.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "${client.client-service.url}")
public interface ClientOpenFeign {

    @GetMapping("/api/clients/exist/{id}")
    ResponseEntity<Void> checkClientExists(@PathVariable("id") Long clientId);
}
