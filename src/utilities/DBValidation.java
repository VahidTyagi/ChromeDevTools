package utilities;

import java.sql.ResultSet;

public class DBValidation {

    public static boolean validateValue(String query, String expectedValue) throws Exception {
        ResultSet rs = DBUtility.executeQuery(query);
        rs.next();
        String dbValue = rs.getString(1);
        return dbValue.equals(expectedValue);
    }
}
