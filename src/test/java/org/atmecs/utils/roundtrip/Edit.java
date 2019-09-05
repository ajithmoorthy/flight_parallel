package org.atmecs.utils.roundtrip;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.utils.constants.Filepath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Edit extends Pricechoosen {
	@DataProvider(name = "edit")
	public String[][] getedit() throws IOException {
		String array[][] = null;
		array = app.returnLocator(Filepath.edit_file);
		return array;

	}

	@Test(priority = 2, dataProvider = "edit")
	public void edit(String firstname, String lastname) throws IOException, InterruptedException {
		Properties prop = property(Filepath.editloc_file);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("loc.radiobtn.mr.xpath"))));
		driver = help.click(prop.getProperty("loc.radiobtn.mr.xpath"), driver);
		
		Thread.sleep(2000);
		driver.close();
	}

}
