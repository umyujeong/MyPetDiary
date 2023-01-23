package com.mpd.mypetdiary.mapper;

import com.mpd.mypetdiary.data.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM USER WHERE id=#{id}")
    Account readAccount(String id);

    @Select("SELECT authority_name FROM AUTHORITY WHERE id=#{id}")
    List<String> readAuthorities(String id);

    @Insert("INSERT INTO USER VALUES(#{account.id},#{account.pw},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
    void insertUser(@Param("account") Account account);

    @Insert("INSERT INTO AUTHORITY VALUES(#{id},#{authority})")
    void insertUserAuthority(@Param("id") String id, @Param("authority") String authority);

    @Select("SELECT* FROM USER")
    List<String> readAllUsers();
}
