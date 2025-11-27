import java.sql.*;

public class RowCount {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM users");

        rs.next();
        System.out.println("Total Rows = " + rs.getInt(1));

        con.close();
    }
}
