package com.flaco.ecommerce_platform;

import com.flaco.ecommerce_platform.model.ERole;
import com.flaco.ecommerce_platform.model.Role;
import com.flaco.ecommerce_platform.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommercePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommercePlatformApplication.class, args);
    }

    // CommandLineRunner that populates default roles in the database
    @Bean
    public CommandLineRunner initialRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
                Role userRole = new Role();
                userRole.setName(ERole.ROLE_USER);
                roleRepository.save(userRole);
            }
            if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName(ERole.ROLE_ADMIN);
                roleRepository.save(adminRole);
            }
        };
    }
}