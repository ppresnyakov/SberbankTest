package steps;

import pages.InsurancePage;
import pages.SecondInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSecondPageSteps {

    @Step("Нажать оформить онлайн")
    public void SelectBuyInsurance(){
        new SecondInsurancePage().ClickBuyInsuranceOnline();
    }
}

