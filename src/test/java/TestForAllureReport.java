import cucumber.api.java.ca.I;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class TestForAllureReport extends BaseSteps {
    @Test
    @Title("Страхование путешественника")
    public void textInsurance(){
        MainSteps mainSteps = new MainSteps();
        InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
        InsuranceSecondPageSteps insuranceSecondPageSteps = new InsuranceSecondPageSteps();
        SetupPageStep setupPageStep = new SetupPageStep();

        HashMap<String, String> testData = new HashMap<>();

        testData.put("Фамилия страхователя","Пресняков");
        testData.put("Имя страхователя","Павел");
        testData.put("Дата рождения страхователя","");
        testData.put("Дата рождения страхователя","15.12.1993");
        testData.put("Фамилия","Пресняков");
        testData.put("Имя","Павел");
        testData.put("Отчество","Владимирович");
        testData.put("Дата рождения","15.12.1993");
        testData.put("Серия паспорта","195245");
        testData.put("Номер паспорта","365645");
        testData.put("Дата выдачи паспорта","20.06.2005");
        testData.put("Место выдачи паспорта","УФМС какого то района");

        mainSteps.stepSelectInsuranceItem();
        mainSteps.stepSelectInsuranceItem();
        insurancePageSteps.SelectInsuranceItemTraveller();
        insuranceSecondPageSteps.SelectBuyInsurance();
        setupPageStep.PushButtonBuy();


    }
}
