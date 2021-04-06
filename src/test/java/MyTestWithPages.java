import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InsurancePage;
import pages.MainPage;
import pages.SecondInsurancePage;
import pages.SetUpPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class MyTestWithPages extends  BaseTest{


    @Test
    public void newTestInsurance(){
        MainPage mainPage = new MainPage(driver);
        driver.get(baseUrl + "/");
        mainPage.ClickInsuranceItem();
        mainPage.ClickInsuranceItemsLink();

        InsurancePage insurancePage = new InsurancePage(driver);
        insurancePage.ClickInsuranceItemTravellerText();

        SecondInsurancePage secondInsurancePage = new SecondInsurancePage(driver);
        secondInsurancePage.ClickBuyInsuranceOnline();


        SetUpPage setUppage = new SetUpPage(driver);

        setUppage.ClickRegisterInsuranceButton();
        setUppage.fillField("Фамилия страхователя", "Пресняков");
        setUppage.fillField("Имя страхователя", "Павел");
        setUppage.fillField("Дата рождения страхователя", "15.12.1993");
        setUppage.fillField("Фамилия", "Пресняков");
        setUppage.fillField("Имя", "Павел");
        setUppage.fillField("Отчество", "Владимирович");
        setUppage.fillField("Дата рождения", "15.12.1993");
        setUppage.fillField("Серия паспорта", "195245");
        setUppage.fillField("Номер паспорта", "365645");
        setUppage.fillField("Дата выдачи паспорта", "20.06.2005");
        setUppage.fillField("Место выдачи паспорта", "УФМС какого то района");


        assertEquals("Пресняков",setUppage.GetFieldValue("Фамилия"));
        assertEquals("Павел",setUppage.GetFieldValue("Имя"));

        setUppage.ClickContinueButton();

        assertEquals("При заполнении данных произошла ошибка",setUppage.GetErrorMessage());

    }


}
