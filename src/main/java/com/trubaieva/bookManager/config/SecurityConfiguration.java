package com.trubaieva.bookManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
    @EnableWebSecurity
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(final AuthenticationManagerBuilder auth)
                throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
                    .and()
                    .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
        }

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .antMatchers("/", "/index").permitAll()
                    .antMatchers("/bookList").access("hasRole('ROLE_ADMIN')")
                    .and().exceptionHandling().accessDeniedPage("/403")
                    .and().formLogin().permitAll().failureForwardUrl("/index");
        }

    @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

