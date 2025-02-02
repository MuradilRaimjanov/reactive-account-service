package com.example.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("accounts")
public class Account {

    @Id
    private Long id;

    private String accountType;

    private String accountNumber;

    private LocalDate creationDate;

    private String status;

    private Long clientId;
}
