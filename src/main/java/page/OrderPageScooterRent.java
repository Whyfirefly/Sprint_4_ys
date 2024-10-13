package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static constants.ColoursOfScooter.*;

public class OrderPageScooterRent {

  //Локатор логотипа Яндекса
  private final By yandexLogo = By.xpath("//img[@alt = 'Yandex']");

  //Локатор для заголовка страницы про аренду
  private final By titleRentalInfo = By.xpath("//*[@class = 'Order_Header__BZXOb' and text() = 'Про аренду']");
  //Локатор для поля даты доставки
  private final By dateDeliveryField = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
  //Локатор для поля срока аренды
  private final By rentalPeriodField = By.className("Dropdown-placeholder");
  //Локатор для черного цвета самоката
  private final By colourBlack = By.id("black");
  //Локатор для серого цвета самоката
  private final By colourGrey = By.id("grey");
  //Локатор для поля комментария курьеру
  private final By commentDeliveryField = By.xpath("//input[@placeholder = 'Комментарий для курьера']");

  //Локатор для кнопки Заказать
  private final By orderButton = By.xpath("//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");

  private final WebDriver driver;

  //добавили конструктор класса page object
  public OrderPageScooterRent(WebDriver driver) {
    this.driver = driver;
  }

  //метод ожидания загрузки страницы "Для кого самокат"
  public OrderPageScooterRent waitAboutRentHeader() {
    new WebDriverWait(driver, 5).until(driver -> (driver.findElement(titleRentalInfo).getText() != null
            && !driver.findElement(titleRentalInfo).getText().isEmpty()
    ));
    return this;
  }

  //заполнение даты аренды самоката
  public OrderPageScooterRent setDateDelivery(String dateDelivery){

    driver.findElement(dateDeliveryField).sendKeys(dateDelivery);
    driver.findElement(dateDeliveryField).sendKeys(Keys.ENTER);

    return this;
  }

  //заполнение периода аренды самоката
  public OrderPageScooterRent setRentalPeriod(String rentalPeriod){

    driver.findElement(rentalPeriodField).click();

    driver.findElement(By.xpath("//*[text() = '" + rentalPeriod + "']")).click();

    return this;
  }

  //заполнение цвета арендуемого самоката
  public OrderPageScooterRent setColourOfScooterChangeColour(Enum colour) {
    if (colour.equals(BLACK)) {
      driver.findElement(colourBlack).click();
    } else if (colour.equals(GREY)) {
      driver.findElement(colourGrey).click();
    }
    return this;
  }

  //заполнение комментария для курьера
  public OrderPageScooterRent setCommentDelivery(String commentDelivery){

    driver.findElement(commentDeliveryField).sendKeys(commentDelivery);

    return this;
  }

  //заполнение данных об аренде самоката - шаг
  public OrderPageScooterRent setRentalInfo(String dateDelivery, String rentalPeriod, String colourOfScooter, String commentDelivery){

    new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(titleRentalInfo));

    setDateDelivery(dateDelivery);
    setRentalPeriod(rentalPeriod);
    setColourOfScooterChangeColour(BLACK);
    setCommentDelivery(commentDelivery);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    return this;
  }

  //клик кнопки "Заказать" в pop-up
  public OrderPageScooterRent clickOrderButton(){

    driver.findElement(orderButton).click();

    return this;
  }


}
