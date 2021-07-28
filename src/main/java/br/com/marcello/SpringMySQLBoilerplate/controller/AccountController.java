package br.com.marcello.SpringMySQLBoilerplate.controller;

import br.com.marcello.SpringMySQLBoilerplate.dto.AccountDto;
import br.com.marcello.SpringMySQLBoilerplate.dto.request.CreateAccountRequest;
import br.com.marcello.SpringMySQLBoilerplate.exception.ApiException;
import br.com.marcello.SpringMySQLBoilerplate.exception.NotFoundException;
import br.com.marcello.SpringMySQLBoilerplate.model.Account;
import br.com.marcello.SpringMySQLBoilerplate.service.crud.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Accounts Controller", description = "Endpoints for accounts")
@RestController
@Validated
@RequestMapping("/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Create account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account created with success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AccountDto.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server error.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class))
                    })
    })
    @PostMapping("/save")
    public ResponseEntity<?> saveAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        return new ResponseEntity<>(this.accountService.saveAccount(createAccountRequest), HttpStatus.OK);
    }

    @Operation(summary = "Find account by username.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Account.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Account not found.",
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
    @GetMapping
    public ResponseEntity<?> findByUsername(@RequestParam String username) throws NotFoundException {
        return new ResponseEntity<>(this.accountService.findAccountByUsername(username), HttpStatus.OK);
    }

    @Operation(summary = "Get all accounts.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accounts found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AccountDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "None accounts found.",
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
    public ResponseEntity<?> findAllAccounts() throws NotFoundException {
        return new ResponseEntity<>(this.accountService.findAll(), HttpStatus.OK);
    }

}
