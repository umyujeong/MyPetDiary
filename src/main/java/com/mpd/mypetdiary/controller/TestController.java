package com.mpd.mypetdiary.controller;

import com.google.gson.Gson;
import com.mpd.mypetdiary.dto.TestDto;
import com.mpd.mypetdiary.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    // 컨트롤러 테스트
    // MEMBER의 MEMBER_ID가 test인 데이터의 등록일자(MEMBER_REGDATE)를 반환함
    @RequestMapping("/test")
    String test() {
        TestDto testDTO = service.getTestData();
        String testData = new Gson().toJson(testDTO);
        return testData;
    }



}

