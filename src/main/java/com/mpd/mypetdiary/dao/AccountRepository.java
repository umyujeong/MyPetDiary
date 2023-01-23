package com.mpd.mypetdiary.dao;

import com.mpd.mypetdiary.data.Account;
import com.mpd.mypetdiary.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {
    @Autowired
    AccountMapper accountMapper;


    public Account save(Account account, String role){
        accountMapper.insertUser(account);
        accountMapper.insertUserAuthority(account.getUsername(), role);
        return account;
    }

    public Account findById(String username) {
        return accountMapper.readAccount(username);
    }

    public List <String> findAuthoritiesById(String username){
        return accountMapper.readAuthorities(username);
    }
}
