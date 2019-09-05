package org.atmecs.utils.flight_ticket;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.helper.Help;
import org.openqa.selenium.JavascriptExecutor;
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
	public void price(String mobile, String email) throws IOException {
		Properties prop = property(Filepath.next_file);
		
		driver=help.click(prop.getProperty("loc.btn.onewayprice.xpath"), driver);
		 driver = help.click(prop.getProperty("loc.btn.continue.xpath"), driver);
			driver = help.click(prop.getProperty("loc.btn.continue.xpath"), driver);
			Properties prop1 = property(Filepath.select_file);
			driver.switchTo().defaultContent();
			driver = help.sendkeysInt(prop1.getProperty("loc.txtfield.phone.xpath"), driver, mobile);
			driver = help.sendkeysString(prop1.getProperty("loc.txtfield.email.xpath"), driver, email);
			driver = help.click(prop1.getProperty("loc.submitbtn.next.xpath"), driver);
	}

}
