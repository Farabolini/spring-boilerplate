package br.com.marcello.SpringMySQLBoilerplate.integration;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public class AbstractDatabaseIntegration extends IntegrationTest {

    static final MySQLContainer<?> mySQL;

    static {
        mySQL = new MySQLContainer<>("mysql:latest")
                .withDatabaseName("testDatabase")
                .withUsername("testUser")
                .withPassword("test");
        mySQL.start();
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQL::getJdbcUrl);
        registry.add("spring.datasource.username", mySQL::getUsername);
        registry.add("spring.datasource.password", mySQL::getPassword);
    }

}
