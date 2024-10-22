package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchEmptyStatusOrder {

  WebDriver driver;

  private final By notFound = By.xpath(".//*[@alt='Not found']");

  public SearchEmptyStatusOrder(WebDriver driver) {
    this.driver = driver;
  }

  public SearchEmptyStatusOrder waitLoadOrderStatusPage() {
    new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(notFound));
    return this;
  }
}
