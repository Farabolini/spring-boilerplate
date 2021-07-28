package br.com.marcello.SpringMySQLBoilerplate.controller;

import br.com.marcello.SpringMySQLBoilerplate.dto.RoleDto;
import br.com.marcello.SpringMySQLBoilerplate.exception.ApiException;
import br.com.marcello.SpringMySQLBoilerplate.exception.NotFoundException;
import br.com.marcello.SpringMySQLBoilerplate.service.crud.RoleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Operation(summary = "Get all roles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RoleDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "None roles found.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server error.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class))
                    })
    })
    @GetMapping("/list")
    public ResponseEntity<?> listAllRoles() throws NotFoundException {
        return new ResponseEntity<>(this.roleService.findAll(), HttpStatus.OK);
    }

}
