package com.lexuantung.hrm2.config;


import com.lexuantung.hrm2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    //@Qualifier("empDetailServiceImpl")
    @Autowired
    private EmpService empService;
    @Qualifier("empDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;




    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(
//                        "/registration**",
//                        "/js/**",
//                        "/css/**",
//                        "/img/**",
//                        "/webjars/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
//      //  http.authorizeRequests().anyRequest().hasRole("user");
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/").hasRole("user")
                .antMatchers("/admin","/admin/").hasRole("admin")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
//                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

    }
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }




}

