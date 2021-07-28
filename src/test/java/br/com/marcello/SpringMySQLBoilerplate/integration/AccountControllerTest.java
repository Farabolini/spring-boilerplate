package br.com.marcello.SpringMySQLBoilerplate.integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
public class AccountControllerTest extends AbstractDatabaseIntegration {

    String URL_PATH = "/accounts";

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldFindAccountByUsername() throws Exception {

        this.mockMvc.perform(get(URL_PATH)
                .param("username", "adminTest"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").value("adminTest"))
                .andExpect(jsonPath("$.email").value("adminTest@gmail.com"));
    }

}
