package com.example.easy_school_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class WebSecurityConfig {

        @Bean
        SecurityFilterChain defauSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
                        throws Exception {
                // http.authorizeHttpRequests(
                // (request) -> request.anyRequest().authenticated())
                // .formLogin(Customizer.withDefaults())
                // .httpBasic(Customizer.withDefaults());
                MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
                http.csrf(csrf -> csrf
                                .ignoringRequestMatchers("/saveMsg")
                                .ignoringRequestMatchers("/public/**"))
                                .authorizeHttpRequests(
                                                request -> request
                                                                .requestMatchers(
                                                                                mvcMatcherBuilder.pattern("/dashboard"))
                                                                .authenticated()
                                                                .requestMatchers("/displayMessages").hasRole("ADMIN")
                                                                .requestMatchers("/closeMsg").hasRole("ADMIN")
                                                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                                                .requestMatchers("/student/**").hasRole("STUDENT")
                                                                .requestMatchers("/public/**").permitAll()
                                                                .requestMatchers("/displayProfile").authenticated()
                                                                .requestMatchers("/updateProfile").authenticated()
                                                                .anyRequest().permitAll())
                                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/dashboard")
                                                .failureUrl("/login?error=true").permitAll())
                                .logout(l -> l.logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").permitAll());
                return http.build();
        }

        @Bean
        public PasswordEncoder bcryptEncoder() {
                return new BCryptPasswordEncoder();
        }
}
