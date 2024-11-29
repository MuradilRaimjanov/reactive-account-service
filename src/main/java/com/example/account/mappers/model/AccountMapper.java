package com.example.account.mappers.model;

import com.example.account.dto.request.AccountRequestDto;
import com.example.account.model.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
@Component
@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account dtoToEntity(AccountRequestDto accountRequestDto);
}
