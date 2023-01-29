package com.mpd.mypetdiary.service;

import com.mpd.mypetdiary.dto.TestDto;
import com.mpd.mypetdiary.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestDto getTestData() {
        TestDto testData = testMapper.getTestData();
        return testData;
    }

    @Override
    public String getTestName() {
        return testMapper.getTestName();
    }
}
