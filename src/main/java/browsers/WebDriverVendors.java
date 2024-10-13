package browsers;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static constants.UrlUse.URL_SCOOTER;

public class WebDriverVendors {

  public static WebDriver get(String browserName) {

    WebDriver driver;

    switch (browserName) {

      case "Chrome":

        driver = new ChromeDriver();

        break;

      case "Firefox":

        driver = new FirefoxDriver();

        break;

      case "Edge":

        driver = new EdgeDriver();

        break;

      default: throw new RuntimeException("Browser " + browserName + " not exist");

    }

    driver.manage().window().maximize();

    driver.navigate().to(URL_SCOOTER);

    return driver;

  }
}
