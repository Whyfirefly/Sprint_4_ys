import static constants.OrderButtonCreate.UP_BUTTON;
import static org.hamcrest.CoreMatchers.notNullValue;

import browsers.WebDriverVendors;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePage;
import page.OrderPageClient;

public class ErrorsWithIncorrectOrderFieldsTest {

  private WebDriver driver;
  private String clientName;
  private String clientSurname;
  private String clientAdress;
  private String clientPhoneNumber;
  private String clientUnderground;

  @Before
  public void setUp() {
    driver = WebDriverVendors.get("Chrome");
  }

  @After
  public void teardown() {
    driver.quit();
  }

    @Test
    public void clientNameFieldIsEmpty() {
      HomePage homePage = new HomePage(driver);
      OrderPageClient aboutClient = new OrderPageClient(driver);

      homePage.waitForLoadHomePage()
              .clickAcceptCookie()
              .clickCreateOrderButton(UP_BUTTON);

      aboutClient.waitForLoadOrderPage()
              .clickClientName()
              .clickClientSurname();

      new WebDriverWait(driver, 5);

      MatcherAssert.assertThat("Некорректное имя, это поле не должно быть пустым",clientName, notNullValue());
    }

  @Test
  public void сlientSurnameFieldIsEmpty() {
    HomePage homePage = new HomePage(driver);
    OrderPageClient aboutClient = new OrderPageClient(driver);

    homePage.waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(UP_BUTTON);

    aboutClient.waitForLoadOrderPage()
            .clickClientSurname()
                .clickClientName();


    new WebDriverWait(driver, 5);

    MatcherAssert.assertThat("Некорректная фамилия, это поле не должно быть пустым",clientSurname, notNullValue());
   }

  @Test
  public void clientAdressFieldIsEmpty() {
    HomePage homePage = new HomePage(driver);
    OrderPageClient aboutClient = new OrderPageClient(driver);

    homePage.waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(UP_BUTTON);

    aboutClient.waitForLoadOrderPage()
            .clickClientAddress()
            .clickClientName();

    new WebDriverWait(driver, 5);

    MatcherAssert.assertThat("Некорректный адрес, это поле не должно быть пустым",clientAdress, notNullValue());
  }

  @Test
  public void clientPhoneNumberFieldIsEmpty() {
    HomePage homePage = new HomePage(driver);
    OrderPageClient aboutClient = new OrderPageClient(driver);

    homePage.waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(UP_BUTTON);

    aboutClient.waitForLoadOrderPage()
            .clickClientPhoneNumber()
            .clickClientName();

    new WebDriverWait(driver, 5);

    MatcherAssert.assertThat("Некорректный телефон, это поле не должно быть пустым",clientPhoneNumber, notNullValue());
  }

  @Test
  public void clientUndergroundFieldIsEmpty() {
    HomePage homePage = new HomePage(driver);
    OrderPageClient aboutClient = new OrderPageClient(driver);

    homePage.waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(UP_BUTTON);

    aboutClient.waitForLoadOrderPage()
            .setClientName("Имя")
            .setClientSurname("Фамилия")
            .setClientAddress("Победы 3")
            .setClientPhoneNumber("89608765674")
            .clickButtonNext();

    new WebDriverWait(driver, 5);

    MatcherAssert.assertThat("Выберите станцию метро, это поле не должно быть пустым",clientUnderground, notNullValue());
  }

}
