/******************************************************************************************
프로그램명 : JDBC_Ex1.java
설명 : 예제 16-1. JDBC를 이용하여 sampledb 데이터베이스에 연결하는 프로그램
       (강의자료의 MySQL 대신 Oracle '자바' 접속 정보 system@localhost:1521:xe 사용)
작성일시 : 2026.11.19
작성자 : 2023314009_김지용
******************************************************************************************/

import java.sql.*; // Connection, DriverManager, SQLException 등 JDBC API

public class JDBC_Ex1 {
    // SQL Developer '자바' 접속과 같은 설정 (호스트 localhost, 포트 1521, SID xe, 사용자 system)
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    // 비밀번호는 코드에 적지 않고 환경 변수 ORACLE_PWD에서 읽음 (없으면 강의자료처럼 "")
    static final String PASSWORD = System.getenv().getOrDefault("ORACLE_PWD", "");

    public static void main(String[] args) {
        try {
            // MySQL의 com.mysql.jdbc.Driver 대신 Oracle JDBC 드라이버 클래스 로드
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // MySQL URL의 /sampledb 처럼, 이후 SQL은 SAMPLEDB 스키마를 기준으로 실행
            conn.createStatement().execute("ALTER SESSION SET CURRENT_SCHEMA = SAMPLEDB");
            System.out.println("DB 연결 완료");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
        }
    }
}
