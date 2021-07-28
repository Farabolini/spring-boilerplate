package br.com.marcello.SpringMySQLBoilerplate.unit;

import br.com.marcello.SpringMySQLBoilerplate.dto.AccountDto;
import br.com.marcello.SpringMySQLBoilerplate.model.Account;
import br.com.marcello.SpringMySQLBoilerplate.repository.AccountRepository;
import br.com.marcello.SpringMySQLBoilerplate.repository.RoleRepository;
import br.com.marcello.SpringMySQLBoilerplate.service.crud.AccountServiceImpl;
import br.com.marcello.SpringMySQLBoilerplate.service.crud.RoleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
    AccountServiceImpl accountService;
    RoleServiceImpl roleService;

    @BeforeEach
    void setup() {
        this.roleService = new RoleServiceImpl(roleRepository);
        this.accountService = new AccountServiceImpl(accountRepository, roleService);
    }

    @Test
    public void shouldFindByUsername() throws Exception {
        Account account = new Account().toBuilder()
                .username("adminTest")
                .email("adminTest@gmail.com")
                .password("test10")
                .build();
        when(this.accountRepository.findAccountByUsername("adminTest")).thenReturn(account);
        AccountDto accountDto = this.accountService.findAccountByUsername("adminTest");
        assertEquals(accountDto.getUsername(), "adminTest");
        assertEquals(accountDto.getEmail(), "adminTest@gmail.com");
    }

}
