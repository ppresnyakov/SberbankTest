package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {


    @Step("Выбран пункт меню Страхование")
    public void stepSelectInsuranceItem(){
       new MainPage().ClickInsuranceItem();
    }

    @Step("Выбрать Перейти в Каталог")
    public void stepChooseCatalog(){
        new MainPage().ClickInsuranceItemsLink();
    }
}
