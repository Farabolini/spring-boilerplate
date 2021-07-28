package br.com.marcello.SpringMySQLBoilerplate.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {

    private String description;
    private Integer statusCode;

}
