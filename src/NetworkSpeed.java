import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.ConnectionType;

public class NetworkSpeed {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable Network
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Slow network → 3 seconds latency, 20kbps upload, 100kbps download
        devTools.send(Network.emulateNetworkConditions(
                false,
                3000,     // latency
                20000,    // downloadThroughput
                100000,   // uploadThroughput
                Optional.of(ConnectionType.ETHERNET)
        ));

        // Listener for failed requests
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println("Error: " + loadingFailed.getErrorText());
            System.out.println("Time: " + loadingFailed.getTimestamp());
        });

        long startTime = System.currentTimeMillis();

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

        String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);

        long endTime = System.currentTimeMillis();
        System.out.println("Total Load Time: " + (endTime - startTime));

        driver.quit();
    }
}
