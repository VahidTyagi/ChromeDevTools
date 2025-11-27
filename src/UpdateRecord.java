import java.sql.*;

public class UpdateRecord {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");

        PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET email=? WHERE id=?");

        ps.setString(1, "updated@gmail.com");
        ps.setInt(2, 2);

        ps.executeUpdate();
        System.out.println("Record Updated");

        con.close();
    }
}
