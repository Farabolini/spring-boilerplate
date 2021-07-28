package br.com.marcello.SpringMySQLBoilerplate.service.crud;

import br.com.marcello.SpringMySQLBoilerplate.dto.AccountDto;
import br.com.marcello.SpringMySQLBoilerplate.dto.request.CreateAccountRequest;
import br.com.marcello.SpringMySQLBoilerplate.exception.NotFoundException;
import br.com.marcello.SpringMySQLBoilerplate.model.Account;
import br.com.marcello.SpringMySQLBoilerplate.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleServiceImpl roleService;

    public AccountServiceImpl(AccountRepository accountRepository, RoleServiceImpl roleService) {
        this.accountRepository = accountRepository;
        this.roleService = roleService;
    }

    @Override
    public AccountDto saveAccount(CreateAccountRequest accountRequest) {
        Account account = new Account().toBuilder()
                .username(accountRequest.getUsername())
                .email(accountRequest.getEmail())
                .password(accountRequest.getPassword())
                .role(this.roleService.findByRoleName("USER"))
                .build();
        this.accountRepository.save(account);

        return new AccountDto().toBuilder()
                .username(accountRequest.getUsername())
                .email(accountRequest.getEmail())
                .build();
    }

    @Override
    public AccountDto findAccountByUsername(String username) throws NotFoundException {
        Account account = this.accountRepository.findAccountByUsername(username);

        if(account == null)
            throw new NotFoundException("None account found with username: " + username);

        return new AccountDto().toBuilder()
                .username(account.getUsername())
                .email(account.getEmail())
                .build();
    }

    @Override
    public List<AccountDto> findAll() throws NotFoundException{
        List<Account> accounts = this.accountRepository.findAll();

        if(accounts.size() == 0)
            throw new NotFoundException("None account found");

        List<AccountDto> response = new ArrayList<>();
        accounts.forEach(
                account -> response.add(
                        new AccountDto().toBuilder()
                                .username(account.getUsername())
                                .email(account.getEmail())
                                .build())
        );

        return response;
    }
}
