package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{


    @Step("Выбран пункт меню Страхование")
    public void stepSelectInsuranceItem(){
       new MainPage(driver).ClickInsuranceItem();
    }

    @Step("Выбрать Перейти в Каталог")
    public void stepChooseCatalog(){
        new MainPage(driver).ClickInsuranceItemsLink();
    }
}
