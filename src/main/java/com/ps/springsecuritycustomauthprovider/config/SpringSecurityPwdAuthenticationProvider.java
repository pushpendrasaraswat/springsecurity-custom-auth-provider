package com.ps.springsecuritycustomauthprovider.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ps.springsecuritycustomauthprovider.model.Authority;
import com.ps.springsecuritycustomauthprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ps.springsecuritycustomauthprovider.model.Customer;
import com.ps.springsecuritycustomauthprovider.repository.CustomerRepository;

@Component
public class SpringSecurityPwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        Customer customer = userService.findByEmail(userName);

        if (passwordEncoder.matches(password, customer.getPwd())) {
            return new UsernamePasswordAuthenticationToken(userName, password, getGrantedAuthorities(customer.getAuthorities()));
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }


    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
