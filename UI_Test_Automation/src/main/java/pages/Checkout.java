package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {

  public WebDriver driver;

  public Checkout(WebDriver driver) {
    this.driver = driver;
  }

  private By continueButton = By.xpath("//input[@id='continue']");


  @Step("Fill field \"First Name\" with data ({firstname}), fill field \"Last Name\" with data ({lastName}), fill field \"ZipCode\" with data ({postalCode})")
  public void fillFields(String firstname, String lastName, String postalCode) {
    driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
    driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
    driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalCode);
  }

  @Step("Click \"CONTINUE\" button on the Checkout page")
  public void clickContinueButton() {
    driver.findElement(continueButton).click();
  }

}