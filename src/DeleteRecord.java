import java.sql.*;

public class DeleteRecord {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");

        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM users WHERE id=3");

        System.out.println("Record Deleted");
        con.close();
    }
}
