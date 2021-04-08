package com.toptal.webpages;

import com.toptal.webpages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.TimeUnit;

public class DeveloperApplyPageTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "/home/passos/Downloads/firefox/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void developerApplyPage() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnDeveloperApplyButton();

        //Create object of DeveloperApplyPage
        DeveloperApplyPage devportal= new DeveloperApplyPage(driver);

        //Check if page is opened
        assertTrue(devportal.isPageOpened());

        //Create object of DeveloperApplyPage
        DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);

        //Check if page is opened
        assertTrue(applyPage.isPageOpened());

        //Fill up data
        applyPage.setDeveloper_email("dejan@toptal.com");
        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");

        //Accept Cookies to not obscure the join button
        applyPage.clickOnAcceptCookies();

        //Click on join
        applyPage.clickOnJoin();
    }

    @AfterEach
    public void close(){
        driver.close();
    }
}