import browsers.WebDriverVendors;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.SearchEmptyStatusOrder;

import static org.junit.Assert.assertEquals;

public class SearchEmtyStatusOrderTest {
  WebDriver driver;
  private final String numberOrder = " ";


  @Before
  public void setUp() {
    driver = WebDriverVendors.get("Chrome");
  }

  @After
  public void teardown() {
    driver.quit();
  }

  @Test
  public void searchOrderStatusWithoutNumber() {
    new HomePage(driver)
            .waitForLoadHomePage()
            .clickOrderState()
            .inputOrderNumber(numberOrder)
            .clickGo();

    new SearchEmptyStatusOrder(driver)
            .waitLoadOrderStatusPage();
  }
}
