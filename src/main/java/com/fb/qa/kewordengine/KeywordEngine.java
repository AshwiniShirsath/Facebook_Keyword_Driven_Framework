package com.fb.qa.kewordengine;

import com.fb.qa.testbase.TestPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class KeywordEngine {

    public final String TESTDATA_SHEET_PATH = "E:\\Facebook_KeywordDriven_Framework\\src\\main\\java\\com\\fb\\qa\\loginsheet\\LoginDataSheet.xlsx";
    public WebDriver driver;
    public Properties prop;
    public TestPage basePage;
    public Workbook book;
    public Sheet sheet;
    public WebElement element;

    public void startExecution(String sheetName) {

        By loacator;
        String locatorName = null;
        String locatorValue = null;
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        int k = 0;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            try {
                String locatorColValue = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
                if (!locatorColValue.equalsIgnoreCase("NA")) {
                    locatorName = locatorColValue.split("=")[0].trim();
                    locatorValue = locatorColValue.split("=")[1].trim();
                }
                String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
                String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();

                switch (action) {

                    case "open browser":
                        basePage = new TestPage();
                        prop = basePage.init_Properties();
                        if (value.isEmpty() || value.equals("NA")) {
                            driver = basePage.init_driver(prop.getProperty("browser"));
                        } else {
                            driver = basePage.init_driver(value);
                        }
                        break;

                    case "enter url":
                        if (value.isEmpty() || value.equals("NA")) {
                            driver.get(prop.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;
                    case "quit":
                        driver.quit();
                        break;
                    default:
                        break;

                }
                switch (locatorName) {
                    case "id":
                        WebElement element = driver.findElement(By.id(locatorName));
                        if (action.equalsIgnoreCase("sendkeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        }
                        locatorName = null;
                        break;

                    case "linkText":
                        element = driver.findElement(By.linkText(locatorName));
                        element.click();
                        locatorName = null;
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {

            }
        }

    }
}

	