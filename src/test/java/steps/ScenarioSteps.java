package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    InsuranceSecondPageSteps insuranceSecondPageSteps = new InsuranceSecondPageSteps();
    SetupPageStep setupPageStep = new SetupPageStep();

    @When("^нажата иконка страхование$")
    public void clickInsuranceItem(){
        mainSteps.stepSelectInsuranceItem();
    }
    @When("^нажато перейти в каталог$")
    public void clickGoToCatalog(){
        mainSteps.stepChooseCatalog();
    }
    @When("^нажато подробнно Страхование путешественника$")
    public void clickPropertiesInsuranceForTravellers(){
        insurancePageSteps.SelectInsuranceItemTraveller();
    }
    @When("^нажато оформить онлайн Страхование путешественника$")
    public void clickRegisterInsuranceForTravellers(){
        insuranceSecondPageSteps.SelectBuyInsurance();
    }
    @When("^нажата кнопка оформить на странице оформления$")
    public void clickRegister(){
        setupPageStep.PushButtonBuy();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> setupPageStep.fillField(field, value));

    }
    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> setupPageStep.checkFillField(field, value));
    }

    @When("^выбран пункт Cтрахование Путешественника")
    public void selectMenuItem(){
        insurancePageSteps.SelectInsuranceItemTraveller();
    }
    @When("^нажата финальная кнопка")
    public void  ClickFinish(){
        setupPageStep.PushContinueButton();
    }
    @Then("^в сообщении об ошибки есть текст \"(.+)\"$")
    public void checkField(String text){
        setupPageStep.CheckError(text);
    }

}
