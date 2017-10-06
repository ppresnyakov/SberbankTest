import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTest {
  private WebDriver driver;
  private String baseUrl;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");


    //driver = new FirefoxDriver();
    driver = new ChromeDriver();
    baseUrl = "https://www.rgs.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testInsurance() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Страхование")).click();
    driver.findElement(By.linkText("ДМС")).click();

    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
    wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath("//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]"))));

    driver.findElement(By.xpath("//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]")).click();

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[@class='modal-title']"))));

    assertEquals("Заявка на добровольное медицинское страхование",
            driver.findElement(By.xpath("//h4[@class='modal-title']")).getText());

    driver.findElement(By.name("LastName")).click();
    driver.findElement(By.name("LastName")).clear();
    driver.findElement(By.name("LastName")).sendKeys("Иванов");
    driver.findElement(By.name("FirstName")).click();
    driver.findElement(By.name("FirstName")).clear();
    driver.findElement(By.name("FirstName")).sendKeys("Иван");
    driver.findElement(By.name("MiddleName")).click();
    driver.findElement(By.name("MiddleName")).clear();
    driver.findElement(By.name("MiddleName")).sendKeys("Иванович");
    new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");
    driver.findElement(By.name("Email")).clear();
    driver.findElement(By.name("Email")).sendKeys("йцукенqwery");
    driver.findElement(By.name("Comment")).click();
    driver.findElement(By.name("Comment")).clear();
    driver.findElement(By.name("Comment")).sendKeys("test");
    driver.findElement(By.cssSelector("input.checkbox")).click();
    driver.findElement(By.id("button-m")).click();

    assertEquals("Иванов", driver.findElement(By.name("LastName")).getAttribute("value"));
    assertEquals("Иванович", driver.findElement(By.name("MiddleName")).getAttribute("value"));
    assertEquals("Иван", driver.findElement(By.name("FirstName")).getAttribute("value"));
    assertEquals("йцукенqwery", driver.findElement(By.name("Email")).getAttribute("value"));
    assertEquals("test", driver.findElement(By.name("Comment")).getAttribute("value"));

    assertEquals("Москва",
            new Select(driver.findElement(By.name("Region"))).getAllSelectedOptions().get(0).getText());
    assertEquals("Введите адрес электронной почты",
            driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")).getText());
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


}
