package com.mpd.mypetdiary.controller;

import com.mpd.mypetdiary.dto.TestDTO;

import com.mpd.mypetdiary.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    
    // 기본 매핑
    @RequestMapping("/")
    String home() {
        return "Hello world!";
    }

    // 컨트롤러 테스트
    // MEMBER의 MEMBER_ID가 test인 데이터의 등록일자(MEMBER_REGDATE)를 반환함
    @RequestMapping("/test")
    String test() {
        TestDTO testData = service.getTestData();
        String testRegdate = testData.getMember_regdate();
        return testRegdate;
    }
}