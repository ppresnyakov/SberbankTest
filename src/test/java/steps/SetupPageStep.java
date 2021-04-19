package steps;

import pages.MainPage;
import pages.SetUpPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetupPageStep {

    @Step("Выбран пункт меню Страхование")
    public void PushButtonBuy(){
        new SetUpPage().ClickRegisterInsuranceButton();
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SetUpPage().fillField(field, value);
    }

    @Step("Заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SetUpPage().GetFieldValue(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("Нажали кнопку продолжть")
    public void PushContinueButton(){
        new SetUpPage().ClickContinueButton();
    }

    @Step("Проверка текста {0} ошибки ")
    public void CheckError(String ExpectedError){
       String ErrorMessage =  new SetUpPage().GetErrorMessage();
        assertEquals(ExpectedError, ErrorMessage);
    }
}
