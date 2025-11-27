import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Database Connected Successfully");

        con.close();
    }
}
