package com.karol.trainingmanager.config;


import com.karol.trainingmanager.security.auth.RegisterRequest;
import com.karol.trainingmanager.services.dev.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import static com.karol.trainingmanager.security.user.Role.ADMIN;
import static com.karol.trainingmanager.security.user.Role.MANAGER;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunnerConfig implements CommandLineRunner {
    private final DataSource dataSource;
    @Value("${spring.datasource.url}")
    private String connectionString;

    @Override
    public void run(String... args) throws Exception {
        initStorage();
        initMetadata();
        logDBConnectionInfo();
    }

    private void initStorage() {
        log.info("initializing storage...");
        log.info("storage initialized");
    }

    private void initMetadata() {
        log.info("initializing metadata...");
        log.info("metadata initialized");
    }

    private void logDBConnectionInfo() throws Exception {
        log.info("startup, connected to " + connectionString + " as "
                + dataSource.getConnection().getMetaData().getUserName());
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());
        };
    }
}
