package br.com.marcello.SpringMySQLBoilerplate.service.crud;

import br.com.marcello.SpringMySQLBoilerplate.dto.AccountDto;
import br.com.marcello.SpringMySQLBoilerplate.dto.request.CreateAccountRequest;
import br.com.marcello.SpringMySQLBoilerplate.exception.NotFoundException;

import java.util.List;

public interface AccountService {

    AccountDto saveAccount(CreateAccountRequest accountRequest);

    AccountDto findAccountByUsername(String username) throws NotFoundException;

    List<AccountDto> findAll() throws NotFoundException;

}
