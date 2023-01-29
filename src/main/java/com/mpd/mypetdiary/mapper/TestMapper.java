package com.mpd.mypetdiary.mapper;

import com.mpd.mypetdiary.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    @Select("SELECT * FROM member WHERE member_id='test@email.com'")
    TestDto getTestData();

    @Select("SELECT member_name FROM member WHERE member_id='test@email.com'")
    String getTestName();
}
