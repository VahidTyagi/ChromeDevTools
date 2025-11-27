import java.sql.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateUIWithDB {
    public static void main(String[] args) throws Exception {

        // DB Connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT username FROM users WHERE id=1");
        rs.next();
        String dbUser = rs.getString("username");

        // UI Fetch
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        String uiUser = driver.findElement(By.id("user-name")).getText();

        // Compare
        if (dbUser.equals(uiUser))
            System.out.println("PASS: UI data matches DB data");
        else
            System.out.println("FAIL: Mismatch Found");

        driver.quit();
        con.close();
    }
}
