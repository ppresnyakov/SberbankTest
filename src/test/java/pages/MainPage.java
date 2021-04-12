package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu__list kitt-top-menu__list_icons kitt-top-menu__list_center')]/li/*[contains(text(),'Страхование')]")
    WebElement InsuranceItem;

    @FindBy(xpath = "//*[contains(text(),'Перейти в каталог')]")
    WebElement InsuranceItemsLink;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void ClickInsuranceItem(){
        InsuranceItem.click();
    }

    public void ClickInsuranceItemsLink(){
        InsuranceItemsLink.click();
    }
}
