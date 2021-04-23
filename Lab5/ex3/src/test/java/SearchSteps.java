import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class SearchSteps {

    private WebDriver webDriver;
    WebDriver driver = new ChromeDriver();

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    @And("I type {string}")
    public void iType(String searchQuery) {
        webDriver.findElement(By.name("q")).sendKeys(searchQuery);
    }

    @And("I press Enter")
    public void iPressEnter() throws InterruptedException {
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(1);
    }

    @Then("I should enter the BlazeDemo website and register my flight")
    public void iShouldBeShownResultsIncluding() {

        driver.findElement(By.cssSelector(".eKjLze .LC20lb")).click();
        driver.manage().window().setSize(new Dimension(945, 1027));
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'San Diego']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.name("toPort")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Gonçalo Passos");
        driver.findElement(By.id("address")).sendKeys("123 Main St.");
        driver.findElement(By.id("city")).sendKeys("Porto");
        driver.findElement(By.id("state")).sendKeys("Porto");
        driver.findElement(By.id("zipCode")).sendKeys("4410");
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.id("cardType")).click();
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("1234");
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys("07");
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2021");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Gonçalo Passos");
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
