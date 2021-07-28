package br.com.marcello.SpringMySQLBoilerplate.service.crud;

import br.com.marcello.SpringMySQLBoilerplate.dto.RoleDto;
import br.com.marcello.SpringMySQLBoilerplate.exception.NotFoundException;
import br.com.marcello.SpringMySQLBoilerplate.model.Role;
import br.com.marcello.SpringMySQLBoilerplate.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return this.roleRepository.findRoleByName(roleName);
    }

    @Override
    public RoleDto saveRole(Role role) {
        this.roleRepository.save(role);

        return new RoleDto().toBuilder()
                .roleName(role.getRole())
                .build();
    }

    @Override
    public List<RoleDto> findAll() throws NotFoundException {
        List<Role> roles = this.roleRepository.findAll();

        if(roles.size() == 0)
            throw new NotFoundException("None role found.");

        List<RoleDto> rolesDto = new ArrayList<>();
        roles.forEach(
                role -> rolesDto.add(
                        new RoleDto().toBuilder()
                                .roleName(role.getRole()).build())
        );

        return rolesDto;
    }
}
