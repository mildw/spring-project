package com.mildw.minsu.security;

import com.mildw.minsu.dao.AccountRepository;
import com.mildw.minsu.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

import static com.mildw.minsu.util.ModelMapperUtils.getModelMapper;


public class MinsuUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not founded"));

        final UserSession userDetails = getModelMapper().map(account, UserSession.class);
        HashSet<UserAuthority> authorities = new HashSet<>();
        authorities.add(new UserAuthority(UserRole.USER.name()));
        userDetails.setAuthorities(authorities);
        return userDetails;
    }
}
