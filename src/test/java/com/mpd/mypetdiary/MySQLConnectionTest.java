package com.mpd.mypetdiary;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

// DB 연결 테스트
// URL은 application.properties의 spring.datasource.url과 같음

public class MySQLConnectionTest {

    // MySQL Connector 의 클래스. DB 연결 드라이버 정의
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // DB 경로
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

    @Test
    public void testConnection() throws Exception {
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}