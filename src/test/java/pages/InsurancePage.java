package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


public class InsurancePage {

    @FindBy(xpath = "//*[contains(text(),'Страхование для путешественников')][contains(@class,'uc-full__header')]")
    WebElement InsuranceItemTravellerText;

    @FindBy(xpath = "//*[contains(text(),'Закрыть')][contains(@class,'kitt-cookie-warning__close')]")
    WebElement CloseButton;


    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        // ЧТО ЭТО ЗА КОСТЫЛЬ? ПОКА НЕ ПРОКРУТИШЬ ДО ЭЛЕМЕНТА ОН НЕ НАЖМЁТ НА НЕГО И ВЫПАДАЕТ В ОШИБКУ !!!!!!!!!!!!!!!!!!!!!!
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy"+ InsuranceItemTravellerText.getLocation().toString() );
    }

    public InsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        if (CloseButton.isDisplayed() )
        { CloseButton.click();}
    }
    public void ClickInsuranceItemTravellerText(){

        {InsuranceItemTravellerText.click();}
    }

}
