package com.pjmb.wonka.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, active from members where username=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //    /products/                   (Main page/List) for User
        //    /products/showFormForAdd     (Add product) for Admin
        //    /products/showFormForUpdate  (Edit product) for Admin
        //    /products/save               (Save product) for Admin
        //    /products/delete             (Delete product) for Admin

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/products/ ").hasRole("USER")
                                .requestMatchers("/products/list ").hasRole("USER")
                                .requestMatchers("/products/showFormForAdd").hasRole("ADMIN")
                                .requestMatchers("/products/showFormForUpdate").hasRole("ADMIN")
                                .requestMatchers("/products/save").hasRole("ADMIN")
                                .requestMatchers("/products/delete").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/accessDenied")
                );

        return http.build();
    }

}