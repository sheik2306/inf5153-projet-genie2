package com.inf5153.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private MyAuthenticationProvider authProvider;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/documents")
            .and()
            .authorizeRequests()
            .antMatchers("/**")
            .hasAnyRole("Doctor", "Health Proffessional")
            .antMatchers("/**")
            .authenticated()
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))        
            .invalidateHttpSession(true)        
            .deleteCookies("JSESSIONID")    
            .logoutSuccessUrl("/login")
            .and()
            .httpBasic();
            
        http.authenticationProvider(authProvider);
    }
}

