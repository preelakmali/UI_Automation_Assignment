package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart {

  public WebDriver driver;

  public Cart(WebDriver driver) {
    this.driver = driver;
  }

  private By checkoutButton = By.xpath("//button[@id='checkout']");
  private By listOfItems = By.xpath("//div[@class='cart_item']");

  public int listOfItems() {
    List<WebElement> items = driver.findElements(listOfItems);
    return items.size();
  }

  @Step("Click \"CHECKOUT\" button on the Cart page")
  public void clickCheckoutButton() {
    driver.findElement(checkoutButton).click();
  }
}