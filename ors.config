package org.example.demo;
// Declares that this class is in the package 'org.example.demo'

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Marks this class as a configuration class — Spring will treat it like a source of bean definitions

public class CorsConfig {

    @Bean
    // Defines a bean — Spring will create and manage this object

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // Apply CORS settings to all endpoints (e.g., /students, /login, etc.)

                        .allowedOrigins("http://localhost:5173")
                        //  Allow requests from your React app running on port 5174
                        // Make sure there is NO trailing slash and NO leading/trailing space

                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allow these HTTP methods from the frontend

                        .allowedHeaders("*")
                        // Allow all headers from the frontend (e.g., Content-Type, Authorization)

                        .allowCredentials(true)
                        // Allow cookies and credentials (e.g., for session handling or auth headers)

                        .maxAge(3600);
                // Cache CORS configuration for 3600 seconds (1 hour)
            }
        };
    }
}
