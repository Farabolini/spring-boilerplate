package br.com.marcello.SpringMySQLBoilerplate.repository;

import br.com.marcello.SpringMySQLBoilerplate.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM roles r WHERE r.role_name = :roleName", nativeQuery = true)
    Role findRoleByName(@Param("roleName") String roleName);

}
