import java.sql.*;
import java.io.FileWriter;

public class ExportDBToCSV {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users");

        FileWriter fw = new FileWriter("D:\\output.csv");

        while (rs.next()) {
            fw.append(rs.getInt("id") + "," +
                      rs.getString("name") + "," +
                      rs.getString("email") + "\n");
        }

        fw.close();
        con.close();

        System.out.println("CSV Exported Successfully!");
    }
}
