/*import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class SampleSteps {

    private WebDriver webDriver;
    WebDriver browser = new FirefoxDriver();

    @BeforeEach
    void SetUp(){
        System.setProperty("webdriver.gecko.driver", "/home/passos/Downloads/firefox/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage", "https://www.saucelabs.com");
        browser = new FirefoxDriver(options);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.firefoxdriver().setup();
        browser.get(url);
    }

    @And("I type {string}")
    public void iType(String searchQuery) {
        webDriver.findElement(By.name("q")).sendKeys(searchQuery);
    }

    @And("I press Enter")
    public void iPressEnter() {
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @And("I should enter the BlazeDemo website and book my flight")
    public void bookFlight() {

        {
            WebElement element = browser.findElement(By.cssSelector("div:nth-child(2) > div > .tF2Cxc .LC20lb"));
            Actions builder = new Actions(browser);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = browser.findElement(By.tagName("body"));
            Actions builder = new Actions(browser);
            builder.moveToElement(element, 0, 0).perform();
        }
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
    }
}
*/