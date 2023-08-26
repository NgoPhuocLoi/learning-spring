package com.example.easy_school_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain defauSecurityFilterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(
        // (request) -> request.anyRequest().authenticated())
        // .formLogin(Customizer.withDefaults())
        // .httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
                request -> request.requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/assets/**").permitAll()
                        .anyRequest().permitAll())
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true").permitAll())
                .logout(l -> l.logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("phuocloi")
                .password("8f3DXH2z")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
