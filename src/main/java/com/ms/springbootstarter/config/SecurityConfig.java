package com.ms.springbootstarter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Config to protect URL's
     */
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{

        httpSecurity.httpBasic()
                .and()
                .authorizeRequests().antMatchers("/rest/h2-console/**")
                .hasRole("ADMIN").antMatchers("/rest/topic**").hasRole("USER")
                .antMatchers("/rest/hello").permitAll()
                .and().csrf().disable().headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("user").password("user").roles("USER");
    }

}
