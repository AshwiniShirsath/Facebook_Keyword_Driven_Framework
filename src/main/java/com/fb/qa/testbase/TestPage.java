package com.fb.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPage {
	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver(String browserName) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			if (prop.getProperty("headless").equalsIgnoreCase("yes")) {
				// headless mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		}

		return driver;

	}

	public Properties init_Properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"E:\\Facebook_KeywordDriven_Framework\\src\\main\\java\\com\\fb\\qa\\config\\Config.Properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}