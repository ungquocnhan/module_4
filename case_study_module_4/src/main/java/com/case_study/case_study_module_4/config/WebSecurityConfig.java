//package com.case_study.case_study_module_4.config;
//
//import com.case_study.case_study_module_4.service.impl.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private MyUserDetailService userDetailService;
//
//    @Bean
//    protected BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().disable();
//        http.csrf().disable()
//                .formLogin()
//                .defaultSuccessUrl("/", true).permitAll()
//
//                .and().authorizeRequests().antMatchers("/customer/*", "/contract", "/facility/*").hasRole("ADMIN")
//                .and().authorizeRequests().antMatchers("/customer", "/facility").hasAnyRole("USER", "ADMIN")
//                .and().authorizeRequests().antMatchers("/").permitAll()
//
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");
//
//
//        http.authorizeRequests().and().rememberMe()
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(1 * 60 * 60);
//    }
//
//    public PersistentTokenRepository persistentTokenRepository(){
//        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
//        return inMemoryTokenRepository;
//    }
//}
