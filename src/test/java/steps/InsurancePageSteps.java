package steps;

import pages.InsurancePage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurancePageSteps extends BaseSteps{

    @Step("Выбран Страхование путешественника")
    public void SelectInsuranceItemTraveller(){
        new InsurancePage(driver).ClickInsuranceItemTravellerText();
    }


}
