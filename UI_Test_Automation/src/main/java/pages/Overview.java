package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview {

  public WebDriver driver;

  public Overview(WebDriver driver) {
    this.driver = driver;
  }

  private By finishButton = By.xpath("//button[@id='finish']");
  private By paymentInfoElement = By.xpath("//div[text()='Payment Information']");
  private By shippingInfoElement = By.xpath("//div[text()='Shipping Information']");
  private By priceTotalElement = By.xpath("//div[text()='Price Total']");
  private By itemTotalElement = By.xpath("//div[text()='Item total: $']");
  private By taxElement = By.xpath("//div[text()='Tax: $']");
  private By totalAmountElement =By.xpath("//div[text()='Total: $']");

  @Step("Click \"FINISH\" button on the Overview page")
  public void clickFinishButton() {
    driver.findElement(finishButton).click();
  }
  @Step("Verify \"Payment Information\" Text ")
  public String textOfPaymentInfoElement()
  {
    driver.findElement(paymentInfoElement).isDisplayed();
    return driver.findElement(paymentInfoElement).getText();
  }
  @Step("Verify \"Shipping Information\" Text ")
  public String textOfShippingInfoElement()
  {
    driver.findElement(shippingInfoElement).isDisplayed();
    return  driver.findElement(shippingInfoElement).getText();
  }

  @Step("Verify \"Item Total\" Text ")
  public boolean isDisplayedItemTotalElement()
  {
    return driver.findElement(itemTotalElement).isDisplayed();
  }


  @Step("Verify \"Price Total\" Text ")
  public boolean isDisplayedPriceTotal()
  {
    return driver.findElement(priceTotalElement).isDisplayed();
  }

  @Step("Verify \"Price Total\" Text ")
  public String getItemTotal()
  {
    return driver.findElement(itemTotalElement).getText();
  }

  @Step("Verify \"Tax Element\" displayed ")
  public boolean isDisplayedtaxElement()
  {
    return driver.findElement(taxElement).isDisplayed();
  }
  @Step("Verify \"Tax Element\" Text ")
  public String gettaxElement()
  {
    return driver.findElement(taxElement).getText();
  }

  @Step("Verify \"Total Element\" Text ")
  public boolean isDisplayedtotalAmountElement()
  {
    return driver.findElement(totalAmountElement).isDisplayed();
  }
  @Step("Verify \"Total Element\" Text ")
  public String getTotalAmountElement()
  {
    return driver.findElement(totalAmountElement).getText();
  }

}