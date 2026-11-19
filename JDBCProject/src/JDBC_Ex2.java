import java.sql.*;

public class JDBC_Ex2 {
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

            ResultSet srs = stmt.executeQuery("select * from student");
            printData(srs, "name", "id", "dept");
            srs = stmt.executeQuery("select name, id, dept from student where name='이기자'");
            printData(srs, "name", "id", "dept");

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
        }
    }

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
