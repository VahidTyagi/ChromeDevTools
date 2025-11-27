import java.sql.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithDB {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT username,password FROM login WHERE id=1");
        rs.next();

        String user = rs.getString("username");
        String pass = rs.getString("password");

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        driver.findElement(By.id("user")).sendKeys(user);
        driver.findElement(By.id("pass")).sendKeys(pass);
        driver.findElement(By.id("login")).click();

        System.out.println("Login Performed with DB Credentials");

        driver.quit();
        con.close();
    }
}
