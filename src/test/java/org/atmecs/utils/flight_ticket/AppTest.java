package org.atmecs.utils.flight_ticket;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.helper.Help;
import org.atmecs.utils.testbase.Presetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends Presetup {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 * @throws IOException
	 */
	App app = new App();

	@DataProvider(name = "data")
	public String[][] getdata() throws IOException {
		String array[][] = null;
		array = app.returnLocator(Filepath.input_file);
		return array;
	}
	Help help = new Help();

	@Test(priority = 0, dataProvider = "data")
	public void flightticket(String variable, String variable1) throws IOException, InterruptedException {

		Properties prop = property(Filepath.config_file);
		Properties prop1 = property(Filepath.locator_file);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver = help.click(prop1.getProperty("loc.radiobtn.onewaytrip.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.from.xpath"), driver);
		driver = help.sendkeysdropdown(prop1.getProperty("loc.dropdown.from.xpath"), driver, variable1);
		driver = help.click(prop1.getProperty("loc.dropdown.to.xpath"), driver);
		driver = help.sendkeysdropdown(prop1.getProperty("loc.dropdown.to.xpath"), driver, variable);
		// driver = help.click(prop1.getProperty("loc.options.to.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.date.depart.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.day.depart.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.passenger.xpath"), driver);
		// driver = help.click(prop1.getProperty("loc.btn.passup.xpath"), driver);
		WebElement btn = driver.findElement(By.xpath(prop1.getProperty("loc.btn.passcountdone.xpath")));
		js.executeScript("arguments[0].click();", btn);
		driver = help.click(prop1.getProperty("loc.dropdown.currencyrupee.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.currencydollar.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.radiobtn.minor.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.submitbtn.searchflight"), driver);
		//////////////////////
	}

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {

		AssertJUnit.assertTrue(true);
	}
}
