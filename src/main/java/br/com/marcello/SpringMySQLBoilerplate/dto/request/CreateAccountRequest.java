package br.com.marcello.SpringMySQLBoilerplate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    @NotBlank(message = "Username is obligatory.")
    @Pattern(regexp = "^[A-za-z\\s]*$", message = "Only letters allowed")
    private String username;

    @NotBlank(message = "Email is obligatory")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is obligatory")
    private String password;

}
