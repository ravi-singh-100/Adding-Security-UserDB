package com.SpringSecurity.UserDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Value("${user.authority.devloper}")
    private String DEVLOPER_AUTHORITY;
    @Value("${user.authority.devops")
    private String DEVOPS_AUTHORITY;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().csrf().disable().authorizeHttpRequests()
//                .antMatchers("/tester/**").hasAnyAuthority(TESTER_AUTHORITY)

                .antMatchers(HttpMethod.POST,"/devloper/**").hasAuthority(DEVOPS_AUTHORITY)
                .antMatchers(HttpMethod.POST,"/sre/**").hasAnyAuthority(DEVOPS_AUTHORITY)
                .antMatchers("/devloper/**").hasAnyAuthority(DEVLOPER_AUTHORITY,DEVOPS_AUTHORITY)
                .antMatchers("/devops").hasAnyAuthority(DEVOPS_AUTHORITY)

                .and()
                .formLogin();

    }
    @Bean
    public PasswordEncoder pwe(){
        return new BCryptPasswordEncoder();
    }
}
