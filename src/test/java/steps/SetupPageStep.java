package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SetupPageStep extends BaseSteps{

    @Step("Выбран пункт меню Страхование")
    public void PushButtonBuy(){
        new SetupPageStep().PushButtonBuy();
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SetupPageStep().fillField(field, value);
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }
}
