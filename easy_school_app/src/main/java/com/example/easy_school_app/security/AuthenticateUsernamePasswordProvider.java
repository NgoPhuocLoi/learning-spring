package com.example.easy_school_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.models.Roles;
import com.example.easy_school_app.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticateUsernamePasswordProvider implements AuthenticationProvider {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Person person = personRepository.findByEmail(email);

        if (person == null || !passwordEncoder.matches(password, person.getPwd()))
            throw new BadCredentialsException("Invalid Credentials!");

        return new UsernamePasswordAuthenticationToken(person.getName(), password,
                getGrantedAuthorities(person.getRole()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
