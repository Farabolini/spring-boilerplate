package br.com.marcello.SpringMySQLBoilerplate.repository;

import br.com.marcello.SpringMySQLBoilerplate.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM accounts a WHERE a.username = :username", nativeQuery = true)
    Account findAccountByUsername(@Param("username") String username);

}
