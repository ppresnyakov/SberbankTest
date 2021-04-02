import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InsuranceTravelTest extends BaseTest {

	@Test
	public void testInsurance() throws Exception {
		driver.get(baseUrl + "/");
		click(By.xpath("//ul[contains(@class,'kitt-top-menu__list kitt-top-menu__list_icons kitt-top-menu__list_center')]/li/*[contains(text(),'Страхование')]"));


		click(By.xpath("//*[contains(text(),'Перейти в каталог')]"));

		click(By.xpath("//*[contains(text(),'Страхование для путешественников')][contains(@class,'uc-full__header')]"));

		Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);

		wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Страхование путешественников"));
		click(By.xpath("//*[contains(text(),'Оформить онлайн')][contains(@class,'kitt-button__text')]"));
		click(By.xpath("//*[contains(text(),'Оформить')]"));


		String LastName = "Пресняков";
		String FirstName = "Павел";
		String MidName = "Владимирович";
		String BirthDate = "15.12.1993";
		String PassportSeries = "2213";
		String PassportNumber = "192536";
		String PassportDate = "22.10.2010";
		String PassportData = "УФМС Фантастического мира";

		fillField(By.id("surname_vzr_ins_0"), LastName);
		fillField(By.id("name_vzr_ins_0"), FirstName);
		fillField(By.id("birthDate_vzr_ins_0"), BirthDate);
		fillField(By.id("person_lastName"), LastName);
		fillField(By.id("person_firstName"), FirstName);
		fillField(By.id("person_middleName"), MidName);
		fillField(By.id("person_birthDate"), BirthDate);
		fillField(By.id("passportSeries"), PassportSeries);
		fillField(By.id("passportNumber"), PassportNumber);
		fillField(By.id("documentDate"), PassportDate);
		fillField(By.id("documentIssue"), PassportData );

		click(By.xpath("//*[contains(text(),'Продолжить')][contains(@class,'btn btn-primary page__btn')]"));

		assertEquals(LastName,driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
		assertEquals(FirstName,driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
		assertEquals(BirthDate,driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
		assertEquals(FirstName,driver.findElement(By.id("person_firstName")).getAttribute("value"));
		assertEquals(LastName,driver.findElement(By.id("person_lastName")).getAttribute("value"));

		assertEquals("При заполнении данных произошла ошибка",
				driver.findElement(By.xpath("//*[contains(@class,'alert-form alert-form-error')]")).getText());

	}


	private void click(By locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
		Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

	}


}
