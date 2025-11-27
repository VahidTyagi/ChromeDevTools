import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class MobileEmulatorTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Send CDP command to emulate mobile screen
        devTools.send(Emulation.setDeviceMetricsOverride(
                600,                      // width
                1000,                     // height
                50,                       // deviceScaleFactor
                true,                     // mobile
                Optional.empty(),         // scale
                Optional.empty(),         // screenWidth
                Optional.empty(),         // screenHeight
                Optional.empty(),         // positionX
                Optional.empty(),         // positionY
                Optional.empty(),         // dontSetVisibleSize
                Optional.empty(),         // screenOrientation
                Optional.empty(),         // viewport
                Optional.empty()          // displayFeature
        ));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Library")).click();

        // driver.quit();
    }
}
