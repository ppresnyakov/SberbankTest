package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InsurancePage {

    @FindBy(xpath = "//*[contains(text(),'Страхование для путешественников')][contains(@class,'uc-full__header')]")
    WebElement InsuranceItemTravellerText;

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        // ЧТО ЭТО ЗА КОСТЫЛЬ? ПОКА НЕ ПРОКРУТИШЬ ДО ЭЛЕМЕНТА ОН НЕ НАЖМЁТ НА НЕГО И ВЫПАДАЕТ В ОШИБКУ !!!!!!!!!!!!!!!!!!!!!!
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy"+ InsuranceItemTravellerText.getLocation().toString() );
    }

    public void ClickInsuranceItemTravellerText(){

        {InsuranceItemTravellerText.click();}
    }

}
