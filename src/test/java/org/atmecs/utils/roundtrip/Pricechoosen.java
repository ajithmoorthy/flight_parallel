package org.atmecs.utils.roundtrip;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.helper.Help;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Pricechoosen extends AppTest {
	Help help = new Help();

	@DataProvider(name = "select")
	public String[][] getmail() throws IOException {
		String array[][] = null;
		array = app.returnLocator(Filepath.test_file);
		return array;
	}

	@Test(priority = 1, dataProvider = "select")
	public void price(String mobile, String email) throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Properties prop = property(Filepath.next_file);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver = help.clickcss(prop.getProperty("loc.btn.t&c.cssselect"), driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver = help.click(prop.getProperty("loc.radiobtn.minorlow.xpath"), driver);
		WebElement lowestpricefrom = driver.findElement(By.xpath(prop.getProperty("loc.frame.price.xpath")));
		js.executeScript("arguments[0].click();", lowestpricefrom);
		WebElement lowestpriceto = driver.findElement(By.xpath(prop.getProperty("loc.frame.price2.xpath")));
		js.executeScript("arguments[0].click();", lowestpriceto);
		driver = help.click(prop.getProperty("loc.btn.continue.xpath"), driver);
		Properties prop1 = property(Filepath.select_file);
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.xpath("loc.frame.contact.xpath")));
		//driver = help.click(prop1.getProperty("loc.btn.skip.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.txtfield.phone.xpath"), driver);
		driver = help.sendkeysInt(prop1.getProperty("loc.txtfield.phone.xpath"), driver, mobile);
		driver = help.sendkeysString(prop1.getProperty("loc.txtfield.email.xpath"), driver, email);
		driver = help.click(prop1.getProperty("loc.submitbtn.next.xpath"), driver);
	}

}
