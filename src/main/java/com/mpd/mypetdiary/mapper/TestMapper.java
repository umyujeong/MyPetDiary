package com.mpd.mypetdiary.mapper;

import com.mpd.mypetdiary.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    TestDTO getTestData();
    String getTestEmail();
}
