/******************************************************************************************
프로그램명 : JDBC_Ex2.java
설명 : 예제 16-2. sampledb의 student 테이블의 모든 데이터를 출력하고,
       이름이 "이기자"인 학생의 데이터를 출력하는 프로그램
       (강의자료의 MySQL 대신 Oracle '자바' 접속 정보 system@localhost:1521:xe 사용)
작성일시 : 2026.11.19
작성자 : 2023314009_김지용
******************************************************************************************/

import java.sql.*; // Connection, DriverManager, Statement, ResultSet, SQLException 등 JDBC API

public class JDBC_Ex2 {
    // SQL Developer '자바' 접속과 같은 설정 (호스트 localhost, 포트 1521, SID xe, 사용자 system)
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    // 비밀번호는 코드에 적지 않고 환경 변수 ORACLE_PWD에서 읽음 (없으면 강의자료처럼 "")
    static final String PASSWORD = System.getenv().getOrDefault("ORACLE_PWD", "");

    public static void main(String[] args) {
        Connection conn;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB 연결 완료");
            stmt = conn.createStatement();
            stmt.execute("ALTER SESSION SET CURRENT_SCHEMA = SAMPLEDB"); // MySQL의 sampledb 선택

            ResultSet srs = stmt.executeQuery("select * from student");   // 모든 데이터 검색
            printData(srs, "name", "id", "dept");
            srs = stmt.executeQuery("select name, id, dept from student where name='이기자'"); // 조건 검색
            printData(srs, "name", "id", "dept");

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }

    // ResultSet의 커서를 next()로 한 행씩 옮기며 지정한 열의 값을 출력
    private static void printData(ResultSet srs, String col1, String col2, String col3)
            throws SQLException {
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("name"));
            if (!col2.equals(""))
                System.out.print("\t|\t" + srs.getString("id"));
            if (!col3.equals(""))
                System.out.println("\t|\t" + srs.getString("dept"));
            else
                System.out.println();
        }
    }
}
