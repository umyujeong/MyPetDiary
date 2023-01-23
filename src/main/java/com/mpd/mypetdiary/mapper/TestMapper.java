package com.mpd.mypetdiary.mapper;

import com.mpd.mypetdiary.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    TestDto getTestData();
    String getTestEmail();
}
