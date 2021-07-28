package br.com.marcello.SpringMySQLBoilerplate.service.crud;

import br.com.marcello.SpringMySQLBoilerplate.dto.RoleDto;
import br.com.marcello.SpringMySQLBoilerplate.exception.NotFoundException;
import br.com.marcello.SpringMySQLBoilerplate.model.Role;

import java.util.List;

public interface RoleService {

    Role findByRoleName(String roleName);

    RoleDto saveRole(Role role);

    List<RoleDto> findAll() throws NotFoundException;

}
