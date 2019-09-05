package org.atmecs.utils.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.flight_ticket.App;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

public class Presetup {
	protected WebDriver driver;
	App app = new App();
	File inputfile = new File("./src/test/resources/testdata/login.xlsx");

	@BeforeSuite
	public void setup() throws IOException {
		Properties prop = property(Filepath.webdriver_file);
		switch (prop.getProperty("webdrivername")) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Ie":
			System.setProperty("webdriver.chrome.driver", "./libs/IEDriver.exe");
			driver = new InternetExplorerDriver();
			break;
		case "microsoftEdge":
			System.setProperty("webdriver.chrome.driver", "./libs/IEDriver.exe");
			driver = new InternetExplorerDriver();
			break;
		}

	}

	public Properties property(String path) throws IOException {
		File file = new File(path);
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		return prop;
	}

}
