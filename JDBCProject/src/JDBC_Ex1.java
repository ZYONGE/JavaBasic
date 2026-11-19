import java.sql.*;

public class JDBC_Ex1 {
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASSWORD = System.getenv().getOrDefault("ORACLE_PWD", "1234");

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
