import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {

    WebDriver browser;

    @BeforeEach
    void SetUp(){
        System.setProperty("webdriver.gecko.driver", "/home/passos/Downloads/firefox/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage", "https://www.saucelabs.com");
        browser = new FirefoxDriver(options);
    }

    @Test
    void site_header_is_on_home_page(){
        browser.get("https://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue((href.isDisplayed()));
    }

    @Test
    public void ex2() {
        browser.get("https://blazedemo.com/");
        browser.manage().window().setSize(new Dimension(550, 691));
        browser.findElement(By.cssSelector(".container:nth-child(3)")).click();
        browser.findElement(By.name("fromPort")).click();
        browser.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = browser.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Berlin']")).click();
        }
        browser.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(4)")).click();
        browser.findElement(By.cssSelector(".btn-primary")).click();
        browser.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
        browser.findElement(By.id("inputName")).click();
        browser.findElement(By.id("inputName")).sendKeys("Gonçalo Freixinho");
        browser.findElement(By.id("address")).click();
        browser.findElement(By.id("address")).sendKeys("124 Main St.");
        browser.findElement(By.id("city")).click();
        browser.findElement(By.id("city")).sendKeys("Nowhere");
        browser.findElement(By.id("state")).click();
        browser.findElement(By.id("state")).sendKeys("Paris");
        browser.findElement(By.id("zipCode")).click();
        browser.findElement(By.id("zipCode")).sendKeys("12345");
        browser.findElement(By.id("cardType")).click();
        browser.findElement(By.cssSelector("option:nth-child(1)")).click();
        browser.findElement(By.id("creditCardNumber")).click();
        browser.findElement(By.id("creditCardNumber")).sendKeys("1234");
        browser.findElement(By.id("nameOnCard")).click();
        browser.findElement(By.id("nameOnCard")).sendKeys("Gonçalo Freixinho");
        browser.findElement(By.cssSelector(".btn-primary")).click();

        assertEquals(browser.getTitle(), "BlazeDemo Confirmation");
    }

    @AfterEach
    void tearDown() {browser.close();}
}