import browsers.WebDriverVendors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.OrderPageClient;
import page.OrderPageFinal;
import page.OrderPageScooterRent;

import static constants.ColoursOfScooter.*;
import static constants.OrderButtonCreate.*;
import static constants.RentDuration.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

  private WebDriver driver;
  private final String clientName;
  private final String clientSurname;
  private final String clientAdress;
  private final String clientUnderground;
  private final String clientPhoneNumber;
  private final String clientDateDelivery;
  private final String clientRentalPeriod;
  private final Enum clientColourOfScooter;
  private final String clientCommentDelivery;
  private final String expectedHeader = "Заказ оформлен";
  private final Enum button;

  public ScooterOrderTest(Enum button, String clientName, String clientSurname, String clientAdress,
                          String clientUnderground, String clientPhoneNumber, String clientDateDelivery,
                          String clientRentalPeriod, Enum clientColourOfScooter, String clientCommentDelivery)
  {
    this.button = button;
    this.clientName = clientName;
    this.clientSurname = clientSurname;
    this.clientAdress = clientAdress;
    this.clientUnderground = clientUnderground;
    this.clientPhoneNumber = clientPhoneNumber;
    this.clientDateDelivery = clientDateDelivery;
    this.clientRentalPeriod = clientRentalPeriod;
    this.clientColourOfScooter = clientColourOfScooter;
    this.clientCommentDelivery = clientCommentDelivery;
  }

  @Before
  public void setUp() {
    driver = WebDriverVendors.get("Chrome");
  }

  @Parameterized.Parameters
  public static Object[][] getTestData() {
    return new Object[][] {
            {UP_BUTTON, "Георгий","Штольц","Улица Победы","1","89087776584","16.10.2024",FOUR_DAYS,BLACK," "},
            {UP_BUTTON, "Имя","Фамилия","Улица Героев","10","89097766584","17.11.2024",ONE_DAY,GREY,"В дом завозить не нужно. Заранее спасибо."},

            {DOWN_BUTTON, "Яна","Шмыглёва","Улица Первомайская","65","89077776584","12.10.2024",SIX_DAYS,GREY,"привезти к остановке"},
            {DOWN_BUTTON, "Алиса","Грац","Улица Парковая","7","89507776684","18.10.2024",TWO_DAYS,BLACK," "},

    };
  }

  @Test
  public void testCreateOrder() {
    new HomePage(driver)
            .waitForLoadHomePage()
            .clickAcceptCookie()
            .clickCreateOrderButton(button);

    new OrderPageClient(driver)
            .setClientInfo(clientName,clientSurname,clientAdress,clientUnderground, clientPhoneNumber)
            .clickButtonNext();

    new OrderPageScooterRent(driver)
            .setRentalInfo(clientDateDelivery, clientRentalPeriod, String.valueOf(clientColourOfScooter), clientCommentDelivery)
            .clickOrderButton();

    OrderPageFinal OrderPageFinal = new OrderPageFinal(driver);
    OrderPageFinal.clickYesRegistrationOrder();

    assertTrue("Что-то пошло не так при оформлении заказа, необходимо перепроверить",OrderPageFinal.getHeaderAfterCreateOrder().contains(expectedHeader));
  }


  @After
  public void teardown() {
    driver.quit();
  }
}