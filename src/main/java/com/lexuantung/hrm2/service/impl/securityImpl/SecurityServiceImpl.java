package com.lexuantung.hrm2.service.impl.securityImpl;


import com.lexuantung.hrm2.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private AuthenticationManager authenticationManager;


    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);



    public String findLoggedInUsername() {
        Object employee = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (employee instanceof UserDetails) {
            return ((UserDetails)employee).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String phone, String password) {

        UserDetails details = userDetailsService.loadUserByUsername(phone);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(details, password, details.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", phone));
        }
    }
}
