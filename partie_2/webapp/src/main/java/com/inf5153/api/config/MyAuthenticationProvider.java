package com.inf5153.api.config;
import java.util.Collections;
import java.util.Objects;

import com.inf5153.api.repositories.UserRepository;
import com.inf5153.api.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
      
        final UsernamePasswordAuthenticationToken upAuth = (UsernamePasswordAuthenticationToken) authentication;
        final String userName = (String) authentication.getPrincipal();

        final String password = (String) upAuth.getCredentials();

        final String storedPassword = userRepository.findByUserName(userName).map(User::getPassword)
            .orElseThrow(() -> new BadCredentialsException("illegal id or passowrd"));

        if (Objects.equals(password, "") || !Objects.equals(password, storedPassword)) {
            throw new BadCredentialsException("illegal id or passowrd");
        }

        final Object principal = authentication.getPrincipal();
        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
            principal, authentication.getCredentials(),
            Collections.emptyList());
        result.setDetails(authentication.getDetails());

        return result;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return true;
    }

}