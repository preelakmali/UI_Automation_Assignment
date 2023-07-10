package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

  public WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  private By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");
  private By addToCartButtons = By.xpath("//button[@class='btn_primary btn_inventory']");


  public void addSeveralItemsToCart() {
    List<WebElement> buttonAddToCart = new ArrayList<>();
    buttonAddToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
    for (int i = 0; i < 3; i++) {
      buttonAddToCart.get(i).click();
    }
  }

  public WebElement getVisibleCartButton() {
    WebElement visibleCartButton = driver.findElement(cartButton);
    return visibleCartButton;
  }


  @Step("Click \"Cart\" icon on the Home page")
  public void clickCartButton() {
    driver.findElement(cartButton).click();
  }

  @Step("Add all product items to cart by clicking \"ADD TO CART\" button near each product on the Home page")
  public void addAllItemsOfProductsToCart() {
    List<WebElement> allProductsAddToCartButtons = driver.findElements(addToCartButtons);
    for (int i = 0; i < allProductsAddToCartButtons.size(); i++) {
      allProductsAddToCartButtons.get(i).click();
    }
  }

}