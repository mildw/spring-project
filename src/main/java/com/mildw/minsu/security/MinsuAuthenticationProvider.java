package com.mildw.minsu.security;

import com.mildw.minsu.dao.AccountRepository;
import org.h2.security.auth.AuthConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class MinsuAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthConfigException {
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        try {
            final Authentication authenticate = super.authenticate(authentication);
            accountRepository.findByUsername(authenticate.getName()).ifPresent(account -> {
                final UserSession principal = (UserSession) authenticate.getPrincipal();
                principal.setName(account.getName());
            });
            return authenticate;
        } catch (BadCredentialsException e) {
            throw e;
        }
    }

}
