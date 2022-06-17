package com.things.customer.xcitycustomerskb.config.jwtConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class KBServletSecurityAutoConfiguration {
    public KBServletSecurityAutoConfiguration() {
    }

    @Bean
    public AuthenticationEntryPoint unauthorisedEntryPoint() {
        return (request, response, authException) -> {
            response.sendError(401, "No authentication token found");
        };
    }
}


// non - lamda -approach
 /*
    return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Request is unauthorised");
            }
        };
  */































