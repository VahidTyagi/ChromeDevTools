package tests;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import base.SeleniumBase;
import utilities.DBUtility;

public class DBTest {

    public static void main(String[] args) throws Exception {

        SeleniumBase.setUp();

        // Get username from DB
        ResultSet rs = DBUtility.executeQuery("SELECT username FROM login WHERE id=1");
        rs.next();
        String dbUser = rs.getString("username");

        SeleniumBase.driver.get("https://example.com/login");
        SeleniumBase.driver.findElement(By.id("user")).sendKeys(dbUser);

        System.out.println("Login with DB username");
        SeleniumBase.tearDown();
    }
}
