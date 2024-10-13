package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPageClient {

  //Локатор логотипа Самокат
  private final By scooterLogo = By.xpath("//img[@alt = 'Scooter']");
  //Локатор логотипа Яндекса
  private final By yandexLogo = By.xpath("//img[@alt = 'Yandex']");
  //Локатор заголовка страницы про клиента
  private final By titleClientInfoPage = By.xpath("//*[@class = 'Order_Header__BZXOb' and text() = 'Для кого самокат']");
  //Локатор поля для имени клиента
  private final By nameField = By.xpath("//input[@placeholder = '* Имя']");
  //Локатор поля для фамилии
  private final By surnameField = By.xpath("//input[@placeholder = '* Фамилия']");
  //Локатор для поля адрес
  private final By addressField = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
  //Локатор для поля станции метро
  private final By undergroundField = By.xpath("//input[@placeholder = '* Станция метро']");
  //Локатор для выпадающего поля со станциями метро
  private final By selectUndergroundField = By.className("select-search__select");
  //Локатор для поля номера телефона
  private final By phoneNumberField = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
  //Локатор для кнопки далее
  private final By nextButton = By.className("Button_Middle__1CSJM");

  private final WebDriver driver;

  //добавили конструктор класса page object
  public OrderPageClient(WebDriver driver) {
    this.driver = driver;
  }

  //метод ожидания загрузки страницы заказа
  public OrderPageClient waitForLoadOrderPage() {
    new WebDriverWait(driver, 6).until(driver -> (driver.findElement(titleClientInfoPage).getText() != null
            && !driver.findElement(titleClientInfoPage).getText().isEmpty()
    ));
    return this;
  }

  //заполняем имя клиента
  public OrderPageClient setClientName(String clientName){

    driver.findElement(nameField).sendKeys(clientName);

    return this;
  }

  //кликаем поле "имя клиента"
  public OrderPageClient clickClientName(){

    driver.findElement(nameField).click();

    return this;
  }

  //заполняем фамилию клиента
  public OrderPageClient setClientSurname(String clientSurname){

    driver.findElement(surnameField).sendKeys(clientSurname);

    return this;
  }

  //кликаем поле "Фамилия"
  public OrderPageClient clickClientSurname(){

    driver.findElement(surnameField).click();

    return this;
  }

  //заполняем адрес клиента
  public OrderPageClient setClientAddress(String clientAddress){

    driver.findElement(addressField).sendKeys(clientAddress);

    return this;
  }

  //кликаем поле "адрес"
  public OrderPageClient clickClientAddress(){

    driver.findElement(addressField).click();

    return this;
  }

  //заполняем метро
  public OrderPageClient setClientUnderground(String clientUnderground){

    driver.findElement(undergroundField).click();

    new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(selectUndergroundField));

    WebElement element = driver.findElement(By.xpath("//button[@value = '"+clientUnderground+"']"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    driver.findElement(By.xpath("//button[@value = '"+clientUnderground+"']")).click();

    return this;
  }

  //заполняем номер телефона клиента
  public OrderPageClient setClientPhoneNumber(String clientPhoneNumber){

    driver.findElement(phoneNumberField).sendKeys(clientPhoneNumber);

    return this;
  }

  //кликаем по полю "номер телефона клиента"
  public OrderPageClient clickClientPhoneNumber(){

    driver.findElement(phoneNumberField).click();

    return this;
  }

  //класс заполнения данных клиента - шаг
  public OrderPageClient setClientInfo(String clientName,String clientSurname,String clientAddress,String clientUnderground,
                                 String clientPhoneNumber)
  {

    new WebDriverWait(driver, 5)
            .until(ExpectedConditions.presenceOfElementLocated(titleClientInfoPage));

    setClientName(clientName);
    setClientSurname(clientSurname);
    setClientAddress(clientAddress);
    setClientUnderground(clientUnderground);
    setClientPhoneNumber(clientPhoneNumber);
    return this;
  }

  //клик по кнопке "Далее"
  public OrderPageClient clickButtonNext(){

    driver.findElement(nextButton).click();

    return this;
  }

  //метод клика по логотипу Самоката
  public void clickScooterButton() {
    driver.findElement(scooterLogo).click();
  }

  //метод клика по логотипу Яндекса
  public void clickYandexButton() {
    driver.findElement(yandexLogo).click();
  }

}
