package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPageFinal {

  //Локатор для заколовка страницы согласия на оформление заказа
  private final By titleRegistrationOrder = By.className("Order_ModalHeader__3FDaJ");
  //Локатор кнопки согласия на оформление заказа
  private final By yesOrderButtonField = By.xpath("//button[text() = 'Да']");
  //Локатор для окна с подтверждением создания заказа
  private final By orderCreatedField = By.xpath("//*[text() = 'Заказ оформлен']");

  private final WebDriver driver;

  //добавили конструктор класса page object
  public OrderPageFinal(WebDriver driver) {
    this.driver = driver;
  }

  // клик по кнопке регистрации заказа
  public OrderPageFinal clickYesRegistrationOrder(){

    new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(titleRegistrationOrder));

    driver.findElement(yesOrderButtonField).click();

    return this;
  }

  //проверка созданного заказа
  public String getHeaderAfterCreateOrder() {
    new WebDriverWait(driver, 10).until(driver -> (driver.findElement(orderCreatedField).getText() != null
            && !driver.findElement(orderCreatedField).getText().isEmpty()
    ));
    return driver.findElement(orderCreatedField).getText();
  }

}
