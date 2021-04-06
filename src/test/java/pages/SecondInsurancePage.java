package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondInsurancePage {

    @FindBy(xpath = "//*[contains(text(),'Оформить онлайн')][contains(@class,'kitt-button__text')]")
    WebElement BuyInsuranceOnline;

    public SecondInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void ClickBuyInsuranceOnline(){
        BuyInsuranceOnline.click();
    }

}
