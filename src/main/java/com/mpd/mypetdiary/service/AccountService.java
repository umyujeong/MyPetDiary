package com.mpd.mypetdiary.service;

import com.mpd.mypetdiary.data.Account;
import com.mpd.mypetdiary.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accounts;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account=accounts.findById(username);
        account.setAuthorities(account.getAuthorities());

        UserDetails userDetails=new UserDetails() {

            @Override
            public boolean isEnabled() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public String getUsername() {
                // TODO Auto-generated method stub
                return account.getUsername();
            }

            @Override
            public String getPassword() {
                // TODO Auto-generated method stub
                return account.getPassword();
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // TODO Auto-generated method stub

                return account.getAuthorities();
            }
        };
        return account;
    }

    public Collection<GrantedAuthority> getAuthorities(String username)
    {
        List<String> string_authorities = accounts.findAuthoritiesById(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities)
        {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }

    public Account save(Account account,String role) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setAccountNonExpired(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
        account.setEnabled(true);
        return accounts.save(account, role);
    }
}
