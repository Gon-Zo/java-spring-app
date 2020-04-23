package com.app.api.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        http.httpBasic()
                .and()
                .authorizeRequests()
                //admin 시작 인증요구
                .antMatchers("/admin/**").hasRole("ADMIN")
                // user 시작 시 인증요구
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/**").permitAll();

//        http.cors().disable()
//                .addFilterBefore()

//        http.addFilterBefore( , BasicAuthenticationFilter.class)
//                .addFilterAfter()
    }

    /**
     * 인증 >> Login
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("woolbro")
                .password("{noop}woolbro")
                .roles("USER");


    }

    // Passwoard 암호화 Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
