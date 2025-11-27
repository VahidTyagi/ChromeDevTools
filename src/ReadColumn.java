import java.sql.*;

public class ReadColumn {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT email FROM users WHERE id=5");

        rs.next();
        System.out.println("Email = " + rs.getString("email"));

        con.close();
    }
}
