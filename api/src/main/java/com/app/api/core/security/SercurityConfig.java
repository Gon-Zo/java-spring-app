package com.app.api.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();

//
//        http.authorizeRequests()
//                .antMatchers("/assets/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                .loginPage("/login")
//                .defaultSuccessUrl("/", true)
//                .successHandler(customAuthenticationSuccessHandler)
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .invalidateHttpSession(true)
//                .logoutSuccessUrl("/")
//                .deleteCookies("JSESSIONID")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .and()
//                .csrf();
//

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

}
