import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsuranceTravelTest {
  private WebDriver driver;
  private String baseUrl;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

    driver = new ChromeDriver();
    baseUrl = "https://www.rgs.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testInsurance() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//ol[contains(@class,'rgs-menu')]/li/*[contains(text(),'Страхование')]")).click();
    driver.findElement(By.xpath("//*[contains(text(),'Выезжающим за рубеж')]")).click();

    assertEquals("Страхование выезжающих за рубеж",
        driver.findElement(By.xpath("//div[@class='page-header']")).getText());

    WebElement calculateInsuranceBtn =  driver.findElement(By.xpath("//*[contains(text(),'Рассчитать ')][contains(@class,'btn')]/.."));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", calculateInsuranceBtn);
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
    wait.until(ExpectedConditions.elementToBeClickable(calculateInsuranceBtn)).click();


    assertEquals("Калькулятор страхования путешественников онлайн",
        driver.findElement(By.xpath("//h1")).getText());

    WebElement countTravelBtn =  driver.findElement(By.xpath("//*[contains(text(),'в течение года')]/.."));
    ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[contains(text(),'Расчет')]")));
   Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(countTravelBtn)).click();

    fillField(By.xpath("//*[contains(text(),'Куда едем')]/ancestor::div[contains(@class,'form-group')]//input"), "Шенген");
    driver.findElement(By.xpath("//*[contains(text(),'Куда едем')]/ancestor::div[contains(@class,'form-group')]//div[@role='listbox']")).click();

    ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);",  driver.findElement(By.name("ArrivalCountryList")));

    driver.findElement(By.name("ArrivalCountryList")).click();
    driver.findElement(By.xpath("//option[text()='Испания']")).click();

    fillField(By.xpath("//*[contains(text(),'Дата первой поездки')]/parent::div//input"), "12122017");
    new Actions(driver).sendKeys( driver.findElement(By.xpath("//*[contains(text(),'Дата первой поездки')]/parent::div//input")), Keys.TAB);

    fillField(By.xpath("(//input[@data-test-name='FullName'])[1]"), "IVAN IVANOV");
    fillField(By.xpath("//input[@data-test-name='BirthDate']"), "12121990");

    ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);",  driver.findElement(By.xpath("//*[contains(text(),'активный отдых')]/ancestor::div/div[@class='toggle off toggle-rgs']")));

    driver.findElement(By.xpath("//*[contains(text(),'активный отдых')]/ancestor::div/div[@class='toggle off toggle-rgs']")).click();
    driver.findElement(By.xpath("//div[@class='form-footer']//input[@data-test-name='IsProcessingPersonalData']/..")).click();


    ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);",  driver.findElement(By.xpath("//button[@data-test-name='NextButton'][contains(text(),'Рассчитать')]")));

    driver.findElement(By.xpath("//button[@data-test-name='NextButton'][contains(text(),'Рассчитать')]")).click();


    assertEquals("Многократные поездки в течение года",
        driver.findElement(By.xpath("//*[contains(text(),'Условия страхования')]/parent::div//strong")).getText());

    assertEquals("Шенген",
        driver.findElement(By.xpath("//*[contains(text(),'Территория')]/parent::div//strong")).getText());

    assertEquals("12.12.1990",
        driver.findElement(By.xpath("//*[contains(text(),'Застрахованный')]/parent::div//strong[contains(@data-bind,'BirthDate')]")).getText());

    assertEquals("IVAN IVANOV",
        driver.findElement(By.xpath("//*[contains(text(),'Застрахованный')]/parent::div//strong[contains(@data-bind,'LastName')]")).getText());


    assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Активный отдых')]/ancestor::div[@class='summary-row']//strong")).getText().contains("Включен"));

//    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
//    wait.until(ExpectedConditions.visibilityOf(
//            driver.findElement(By.xpath("//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]"))));


  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private void fillField(By locator, String value){
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(value);
  }


}
