package ru.itis.springbootdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier(value = "customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers("/").authenticated()
                .antMatchers("/profile").authenticated()
                .antMatchers("/addNote").authenticated()
                .antMatchers("/changeProfile").authenticated()
                .antMatchers("/createChannel").authenticated()
                .antMatchers("/myChannel").authenticated()
                .antMatchers("/note").authenticated()
                .antMatchers("/welcome").permitAll()
                .antMatchers("/help").permitAll()
                .antMatchers("/mainy").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/confirm/**").permitAll();

        http.formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn?error")
                .usernameParameter("email")
                .permitAll();


    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
