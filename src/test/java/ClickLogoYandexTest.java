import browsers.WebDriverVendors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePage;
import page.OrderPageClient;

import static constants.OrderButtonCreate.DOWN_BUTTON;
import static constants.OrderButtonCreate.UP_BUTTON;
import static constants.UrlUse.URL_YANDEX;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClickLogoYandexTest {
  private WebDriver driver;
  private final Enum button;
  private final String clientName;
  private final String clientSurname;
  private final String clientAdress;
  private final String clientUnderground;
  private final String clientPhoneNumber;

  public ClickLogoYandexTest(Enum button, String clientName, String clientSurname, String clientAdress,
                             String clientUnderground, String clientPhoneNumber)
  {
    this.button = button;
    this.clientName = clientName;
    this.clientSurname = clientSurname;
    this.clientAdress = clientAdress;
    this.clientUnderground = clientUnderground;
    this.clientPhoneNumber = clientPhoneNumber;
  }

  @Before
 public void setUp() {
  driver = WebDriverVendors.get("Chrome");
 }

  @Parameterized.Parameters
  public static Object[][] getTestData() {
    return new Object[][] {
            {UP_BUTTON, "Артур","Ким","Улица Победы","1","89088769578"},
            {DOWN_BUTTON, "Алёна","Новик","Улица Северная","7","89098769578"},
    };
  }

  @After
  public void teardown() {
    driver.quit();
  }

  @Test
  public void clickScooterFromOrderPageClient() {
    HomePage homePage = new HomePage(driver);
    OrderPageClient aboutClient = new OrderPageClient(driver);

    homePage.waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(button);

    aboutClient.waitForLoadOrderPage()
            .clickYandexButton();

    //перебираем вкладки, перейдя на самую последнюю
    for (String tab : driver.getWindowHandles()) {
      driver.switchTo().window(tab);
    }

    new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(URL_YANDEX));

    assertEquals("Переход на страницу Яндекса не выполнен", URL_YANDEX, driver.getCurrentUrl());
  }

  @Test
  public void clickScooterFromOrderPageScooterRent() {
    HomePage homePage = new HomePage(driver);
    OrderPageClient aboutRenter = new OrderPageClient(driver);

    homePage.waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(button);

    aboutRenter.waitForLoadOrderPage()
            .setClientInfo(clientName,clientSurname,clientAdress,clientUnderground, clientPhoneNumber)
            .clickButtonNext()
            .clickYandexButton();


    //перебираем вкладки, перейдя на самую последнюю
    for (String tab : driver.getWindowHandles()) {
      driver.switchTo().window(tab);
    }

    new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(URL_YANDEX));

    assertEquals("Переход на страницу Яндекса не выполнен", URL_YANDEX, driver.getCurrentUrl());
  }

}
