package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetUpPage  extends MainPage{

    @FindBy(xpath = "//*[contains(text(),'Оформить')]")
    WebElement RegisterInsuranceButton;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement LastNameField;

    @FindBy(id = "name_vzr_ins_0")
    WebElement FirstNameField;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement BirthDateField;

    @FindBy(id = "person_lastName")
    WebElement LastNameInsuranceField;

    @FindBy(id = "person_firstName")
    WebElement FirstNameInsuranceField;

    @FindBy(id = "person_middleName")
    WebElement MidNameInsuranceField;

    @FindBy(id = "person_birthDate")
    WebElement BirthDateInsuranceField;

    @FindBy(id = "passportSeries")
    WebElement PassportSeriesField;

    @FindBy(id = "passportNumber")
    WebElement PassportNumberField;

    @FindBy(id = "documentDate")
    WebElement PassportDateField;

    @FindBy(id = "documentIssue")
    WebElement PassportDataField;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')][contains(@class,'btn btn-primary page__btn')]")
    WebElement ContinueButton;

    @FindBy(xpath = "//*[contains(@class,'alert-form alert-form-error')]")
    WebElement ErrorMessage;


    public SetUpPage(WebDriver driver) {
        super(driver);
    }


    public void ClickRegisterInsuranceButton(){
        RegisterInsuranceButton.click();
    }
    public void ClickContinueButton(){
        ContinueButton.click();
    }
    public String GetErrorMessage(){
        return ErrorMessage.getText();
    }



    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия страхователя":
                fillField(LastNameField, value);
                break;
            case  "Имя страхователя":
                fillField(FirstNameField, value);
                break;
            case  "Дата рождения страхователя":
                fillField(BirthDateField, value);
                break;
            case  "Фамилия":
                fillField(LastNameInsuranceField, value);
                break;
            case  "Имя":
                fillField(FirstNameInsuranceField, value);
                break;
            case  "Отчество":
                fillField(MidNameInsuranceField, value);
                break;
            case  "Дата рождения":
                fillField(BirthDateInsuranceField, value);
                break;
            case  "Серия паспорта":
                fillField(PassportSeriesField, value);
                break;
            case  "Номер паспорта":
                fillField(PassportNumberField, value);
                break;
            case  "Дата выдачи паспорта":
                fillField(PassportDateField, value);
                break;
            case  "Место выдачи паспорта":
                fillField(PassportDataField, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


    public String GetFieldValue(String fieldName){
        switch (fieldName){
            case  "Фамилия страхователя":
                return LastNameField.getAttribute("value");
            case  "Имя страхователя":
                return  FirstNameField.getAttribute("value");
            case  "Дата рождения страхователя":
                return BirthDateField.getAttribute("value");
            case  "Фамилия":
                return  LastNameInsuranceField.getAttribute("value");
            case  "Имя":
                return  FirstNameInsuranceField.getAttribute("value");
            case  "Отчество":
                return  MidNameInsuranceField.getAttribute("value");
            case  "Дата рождения":
                return BirthDateInsuranceField.getAttribute("value");
            case  "Серия паспорта":
                return  PassportSeriesField.getAttribute("value");
            case  "Номер паспорта":
                return  PassportNumberField.getAttribute("value");
            case  "Дата выдачи паспорта":
                return   PassportDateField.getAttribute("value");
            case  "Место выдачи паспорта":
                return PassportDataField.getAttribute("value");
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }
}
