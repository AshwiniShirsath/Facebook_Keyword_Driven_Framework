package com.fb.qa.testcases;

import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
    }

    @Test(priority = 2)
    public void fpmLogoImageTest() {
        boolean flag = loginPage.validateFPMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void EnterEmailTest() {
        loginPage.EnterEmail(prop.getProperty("email"));
    }

    @Test(priority = 4)
    public void EnterPasswordTest() {
        loginPage.EnterPassword(prop.getProperty("password"));
    }

    @Test(priority = 5)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 6)
    public void validateFPMLoginBtnTest() {
        boolean flag = loginPage.validateFPMLoginBtn();
        Assert.assertTrue(flag);
    }

    @Test(priority = 7)
    public void fpmSignUpBtnTest() {
        boolean flag = loginPage.validateFPMsignUpBtn();
        Assert.assertTrue(flag);
    }

    @Test(priority = 8)
    public void fpmForgotPaswordTest() {
        boolean flag = loginPage.validateFPMforgotpassword();
        Assert.assertTrue(flag);
    }

    @Test(priority = 9)
    public void fpmMLableTest() {
        boolean flag = loginPage.validateFPMLable();
        Assert.assertTrue(flag);
    }

    @Test(priority = 10)
    public void fpmSecondSLableTest() {
        boolean flag = loginPage.validateFPMSecondSLable();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}