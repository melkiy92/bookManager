package com.trubaieva.bookManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
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
                    .and().formLogin().loginPage("/login").failureForwardUrl("/index");
        }

    @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

