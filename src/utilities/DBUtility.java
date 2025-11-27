package utilities;

import java.sql.*;

public class DBUtility {

    public static ResultSet executeQuery(String query) throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery(query);
    }

    public static int executeUpdate(String query) throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeUpdate(query);
    }
}
