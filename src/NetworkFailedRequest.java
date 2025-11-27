import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.fetch.Fetch;
import org.openqa.selenium.devtools.v115.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v115.network.model.ErrorReason;

public class NetworkFailedRequest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Intercept *GetBook* calls
        Optional<List<RequestPattern>> patterns = Optional.of(
                Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty()))
        );

        // Enable Fetch domain
        devTools.send(Fetch.enable(patterns, Optional.empty()));

        // Add listener -> fail the request
        devTools.addListener(Fetch.requestPaused(), request -> {

            devTools.send(Fetch.failRequest(
                    request.getRequestId(),
                    ErrorReason.FAILED
            ));

        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
