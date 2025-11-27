import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable Network tracking
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Block .jpg and .css files
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

        long startTime = System.currentTimeMillis();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();

        System.out.println(driver.findElement(By.cssSelector("p")).getText());

        long endTime = System.currentTimeMillis();
        System.out.println("Page Load Time: " + (endTime - startTime));

        driver.quit();
    }
}
