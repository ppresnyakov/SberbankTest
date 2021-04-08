package steps;

import pages.InsurancePage;
import pages.SecondInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSecondPageSteps extends  BaseSteps{

    @Step("Нажать оформить онлайн")
    public void SelectBuyInsurance(){
        new SecondInsurancePage(driver).ClickBuyInsuranceOnline();
    }
}

