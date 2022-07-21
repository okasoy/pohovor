package skit.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skit.web.service.DocumentService;
import skit.web.service.DocumentServiceJPA;
import skit.web.service.UserService;
import skit.web.service.UserServiceJPA;

@SpringBootApplication
@Configuration
@EntityScan("skit.web.entity")
public class SKITServer {
    public static void main(String[] args) {
        SpringApplication.run(SKITServer.class, args);
    }

    @Bean
    public UserService userService() {
        return new UserServiceJPA();
    }

    @Bean
    public DocumentService documentService() {
        return new DocumentServiceJPA();
    }
}
