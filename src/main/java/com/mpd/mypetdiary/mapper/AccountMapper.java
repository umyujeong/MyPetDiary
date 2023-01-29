package com.mpd.mypetdiary.mapper;

import com.mpd.mypetdiary.data.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM member_spring_security WHERE member_id=#{member_id}")
    Account readAccount(String member_id);

    @Select("SELECT authority_name FROM AUTHORITY WHERE member_id=#{member_id}")
    List<String> readAuthorities(String member_id);

    @Insert("INSERT INTO member_spring_security VALUES(#{account.member_id},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled},#{account.member_pw})")
    void insertUser(@Param("account") Account account);

    @Insert("INSERT INTO authority VALUES(#{member_id},#{authority_name})")
    void insertUserAuthority(@Param("member_id") String member_id, @Param("authority_name") String authority_name);

    @Select("SELECT* FROM member_spring_security")
    List<String> readAllUsers();
}
