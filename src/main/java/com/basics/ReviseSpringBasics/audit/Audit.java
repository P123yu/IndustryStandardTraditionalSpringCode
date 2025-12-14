package com.basics.ReviseSpringBasics.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class Audit {
    @Bean
    public AuditorAware<String> auditorAware() {
        // Replace with logic to get current user from Spring Security if needed
        return () -> Optional.of("system");
    }
}
