package com.mpd.mypetdiary.controller;

import com.mpd.mypetdiary.data.Account;
import com.mpd.mypetdiary.jwt.JwtTokenProvider;
import com.mpd.mypetdiary.mapper.AccountMapper;
import com.mpd.mypetdiary.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    private final JwtTokenProvider jwtTokenProvider;


    //ADMIN 계정 부여
    @GetMapping("/create")
    public Account create(){
        Account account = new Account();
        account.setUsername("admin");
        account.setPassword("1234");
        accountService.save(account, "ROLE_ADMIN");
        return account;
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        String memberId = user.get("id");
        Account member = accountMapper.readAccount(memberId);
        List<String> roles = accountMapper.readAuthorities(memberId);

        return jwtTokenProvider.createToken(member.getUsername(), roles);
    }
}
