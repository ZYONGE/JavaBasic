import java.sql.*;

public class JDBC_Ex3 {
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASSWORD = System.getenv().getOrDefault("ORACLE_PWD", "1234");

    public static void main(String[] args) {
        Connection conn;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB 연결 완료");
            stmt = conn.createStatement();
            stmt.execute("ALTER SESSION SET CURRENT_SCHEMA = SAMPLEDB");

            stmt.executeUpdate("insert into student (name, id, dept) values('아무개', '0893012', '컴퓨터공학')");
            printTable(stmt);
            stmt.executeUpdate("update student set id='0189011' where name='아무개'");
            printTable(stmt);
            stmt.executeUpdate("delete from student where name='아무개'");
            printTable(stmt);

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }

    private static void printTable(Statement stmt) throws SQLException {
        ResultSet srs = stmt.executeQuery("select * from student");
        while (srs.next()) {
            System.out.print(srs.getString("name"));
            System.out.print("\t|\t" + srs.getString("id"));
            System.out.println("\t|\t" + srs.getString("dept"));
        }
    }
}
