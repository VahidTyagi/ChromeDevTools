import java.sql.*;

public class InsertRecord {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email) VALUES(?,?)");

        ps.setString(1, "Rahul");
        ps.setString(2, "rahul@gmail.com");

        ps.executeUpdate();
        System.out.println("Record Inserted");

        con.close();
    }
}
