/******************************************************************************************
프로그램명 : JDBC_Ex3.java
설명 : 예제 16-3. sampledb의 student 테이블에 새로운 학생 정보를 추가하고,
       새로 생성된 학생의 정보를 수정한 후에 다시 삭제하는 프로그램
       - 데이터가 변경될 때마다 테이블의 모든 내용을 출력
       (강의자료의 MySQL 대신 Oracle '자바' 접속 정보 system@localhost:1521:xe 사용)
작성일시 : 2026.11.19
작성자 : 2023314009_김지용
******************************************************************************************/

import java.sql.*; // Connection, DriverManager, Statement, ResultSet, SQLException 등 JDBC API

public class JDBC_Ex3 {
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

            // 레코드 추가 (Oracle JDBC는 SQL 끝의 ';'를 허용하지 않으므로 강의자료의 ';'는 제외)
            stmt.executeUpdate("insert into student (name, id, dept) values('아무개', '0893012', '컴퓨터공학')");
            printTable(stmt);
            // 데이터 수정
            stmt.executeUpdate("update student set id='0189011' where name='아무개'");
            printTable(stmt);
            // 레코드 삭제
            stmt.executeUpdate("delete from student where name='아무개'");
            printTable(stmt);

            conn.close(); // JDBC는 기본이 자동 커밋(auto-commit)이므로 변경 내용은 바로 반영됨
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }

    // student 테이블의 모든 행을 "이름 | 학번 | 학과" 형식으로 출력
    private static void printTable(Statement stmt) throws SQLException {
        ResultSet srs = stmt.executeQuery("select * from student");
        while (srs.next()) {
            System.out.print(srs.getString("name"));
            System.out.print("\t|\t" + srs.getString("id"));
            System.out.println("\t|\t" + srs.getString("dept"));
        }
    }
}
