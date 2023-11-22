package com.example.bookStore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

        @Bean
        public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails mostafa = User.builder()
                .username("mostafa")
                .password("{noop}123")
                .roles("ADMIN","Manager")
                .build();
        UserDetails Ewees = User.builder()
                .username("ewees")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();
        UserDetails Amany = User.builder()
                .username("Amany")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(mostafa,Ewees,Amany );
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        http.authorizeHttpRequests(configurer->
                        configurer.requestMatchers("/").hasAnyRole("ADMIN","EMPLOYEE")
                                .anyRequest().authenticated()
                )
                .formLogin(form->
                        form.loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticationTheUser")
                                .permitAll()
                )
                .logout(logout-> logout.permitAll()
                );
        return http.build();
    }
}
