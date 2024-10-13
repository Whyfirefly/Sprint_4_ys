package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.OrderButtonCreate.*;

public class HomePage {

  private final WebDriver driver;


  //Локатор прогрузки главной страницы
  private final By homeHeader = By.className("Home_Header__iJKdX");
  //Локатор кнопки с принятием Cookies
  private final By acceptCookie = By.id("rcc-confirm-button");
  //Локатор блока FAQ
  private final By questionsHeader = By.className("Home_FourPart__1uthg");
  //Локатор верхней кнопки заказа самоката
  private final By upButtonOrder = By.xpath("//button[@class='Button_Button__ra12g']");
  //Локатор нижней кнопки заказа самоката
  private final By downButtonOrder = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");
  //Локатор кнопки Статуса заказа
  private final By orderState = By.xpath(".//button[text()='Статус заказа']");
  //Локатор поля ввода номера заказа
  private final By numberOrder = By.xpath(".//input[@placeholder='Введите номер заказа']");
  //Локатор кнопки "Go!" при проверке статуса заказа
  private final By buttonGo = By.xpath(".//button[text()='Go!']");
  //Локатор поля поисковой строки Яндекса
  private final By yandexField = By.xpath(".//input[@className='arrow__input']");

  //добавили конструктор класса page object
  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  //метод ожидания загрузки главной страницы
  public HomePage waitForLoadHomePage() {
    new WebDriverWait(driver, 30).until(driver -> (driver.findElement(homeHeader).getText() != null
            && !driver.findElement(homeHeader).getText().isEmpty()
    ));
    return this;
  }

  //Закрывать блок cookies внизу страницы
  public HomePage clickAcceptCookie(){
    driver.findElement(acceptCookie).click();
    return this;
  }

  //метод ожидания загрузки ответа на вопрос
  public void waitLoadAfterClickQuestion(By accordionLabel) {
    new WebDriverWait(driver, 6).until(driver -> (driver.findElement(accordionLabel).getText() != null
            && !driver.findElement(accordionLabel).getText().isEmpty()
    ));
  }

  //метод прокрутки к блоку "Вопросы о важном"
  public HomePage scrollToQuestions() {
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsHeader));
    return this;
  }

  //метод прокрутки ко второй кнопке "Заказать"
  public HomePage scrollToDownOrderButton() {
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downButtonOrder));
    return this;
  }

  public HomePage clickUpOrderButton() {
    driver.findElement(upButtonOrder).click();
    return this;
  }

  public HomePage clickDownOrderButton() {
    driver.findElement(downButtonOrder).click();
    return this;
  }

  public void clickCreateOrderButton(Enum button) {
    if (button.equals(UP_BUTTON)) {
      clickUpOrderButton();
    } else if (button.equals(DOWN_BUTTON)) {
      scrollToDownOrderButton();
      clickDownOrderButton();
    }
  }

  //метод клика по блоку с вопросом из FAQ
  public HomePage clickQuestion(By question) {
    new WebDriverWait(driver, 7)
            .until(ExpectedConditions.elementToBeClickable(question))
            .click();
    return this;
  }

  //метод клика по кнопке "Статус заказа"
  public HomePage clickOrderState() {
    driver.findElement(orderState).click();
    return this;
  }

  //метод заполнения поля при проверке статуса заказа
  public HomePage inputOrderNumber(String number) {
    new WebDriverWait(driver, 3)
            .until(ExpectedConditions.elementToBeClickable(numberOrder))
            .sendKeys(number);
    return this;
  }

  //метод клика по кнопке "Go!" пр проверке статуса заказа
  public HomePage clickGo() {
    new WebDriverWait(driver, 3)
            .until(ExpectedConditions.elementToBeClickable(buttonGo))
            .click();
    return this;
  }

}