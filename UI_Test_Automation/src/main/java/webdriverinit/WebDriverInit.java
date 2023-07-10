package webdriverinit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {

  public WebDriver driver;

  @BeforeClass
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void close() {
    driver.quit();
  }
}