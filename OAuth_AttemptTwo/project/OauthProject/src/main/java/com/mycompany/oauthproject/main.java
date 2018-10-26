package com.mycompany.oauthproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.security.Principal;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class main extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .csrf().disable()
        .antMatcher("/**")
        .authorizeRequests()
          .antMatchers("/", "/login**", "/webjars/**")
          .permitAll()
        .anyRequest()
          .authenticated()
        .and().logout().logoutSuccessUrl("/").permitAll();
  }
    @RequestMapping("/user")
public Principal user(Principal principal) {
       return principal;
}
    public static void main(String[] args)throws Exception{
    SpringApplication.run(main.class,args);
    }
}
