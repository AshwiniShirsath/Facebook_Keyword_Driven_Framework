package com.fb.qa.pages;

import com.fb.qa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BaseClass {

    public static String title;
    public static WebElement firstName;
    public static WebElement lastName;
    public static WebElement email;
    public static WebElement confirmEmail;
    public static WebElement password;
    public static WebElement birthDay;
    public static WebElement birthmonth;
    public static WebElement birthYear;
    public static WebElement gender;
    public static WebElement submitBtn;

    public String verifyTitleOfSignUpPage() {
        title = driver.getTitle();
        return title;
    }

    public String verifyFirstNameField() {
        firstName = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        if (firstName.isEnabled()) {
            firstName.sendKeys("Ashwini");
        }
        return firstName.getAttribute("value");
    }

    public String verifyLastNameField() {
        lastName = driver.findElement(By.name("lastname"));
        if (lastName.isEnabled()) {
            lastName.sendKeys("Shirsath");
        }
        return lastName.getAttribute("value");
    }

    public String verifyEmailTextField() {
        email = driver.findElement(By.name("reg_email__"));
        if (email.isEnabled()) {
            email.sendKeys("ashwinishirsath1221@gmail.com");
        }
        return email.getAttribute("value");
    }

    public String verifyConfirmEmailTextField() {
        confirmEmail = driver.findElement(By.name("reg_email_confirmation__"));
        if (confirmEmail.isEnabled()) {
            confirmEmail.sendKeys("ashwinishirsath1221@gmail.com");
        }
        return confirmEmail.getAttribute("value");
    }

    public String verifyPasswordTextField() {
        password = driver.findElement(By.id("password_step_input"));
        if (password.isEnabled()) {
            password.sendKeys("ashwini1221");
        }
        return password.getAttribute("value");
    }

    public String verifyBirthDayField() {
        birthDay = driver.findElement(By.name("birthday_day"));
        if (birthDay.isEnabled()) {
            birthDay.sendKeys("12");
        }
        return birthDay.getAttribute("value");
    }

    public String verifyBirthmonthField() {
        birthmonth = driver.findElement(By.name("birthday_month"));
        if (birthmonth.isEnabled()) {
            birthmonth.sendKeys("April");
        }
        return birthmonth.getAttribute("value");
    }

    public String verifyBirthYearField() {
        birthYear = driver.findElement(By.name("birthday_year"));
        if (birthYear.isEnabled()) {
            birthYear.sendKeys("1994");
        }
        return birthYear.getAttribute("value");
    }

    public String verifyGenderField() {
        gender = driver.findElements(By.name("sex")).get(2);
        return gender.getAttribute("value");
    }

    public boolean verifySignUpBtnField() {
        submitBtn = driver.findElement(By.name("websubmit"));
        return submitBtn.isEnabled();
    }

}