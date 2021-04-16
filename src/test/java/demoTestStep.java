import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.junit.Assert.*;

public class demoTestStep {
    private WebDriver driver;

    @Before
    public void setup() {
        String driverPath = System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Given("^User is on \"(.*)\" page$")
    public void user_on_page(String url) {
        driver.get(url);
    }

    @When("^User enter \"(.*)\" in search box \"(.*)\"$")
    public void userEnterInSearchBox(String searchKeywords, String textBoxId) {
        driver.findElement(By.id(textBoxId)).sendKeys(searchKeywords);
    }

    @And("^User clicks on Search button \"(.*)\"$")
    public void userClicksOnSearchButton(String searchButtonId) {
        driver.findElement(By.id(searchButtonId)).click();
    }

    @Then("^user should see \"(.*)\"$")
    public void userShouldSee(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        if (!expectedResult.contains("remain")) {
            wait.until(ExpectedConditions.titleContains("_百度搜索"));
            searchResultPageVerify(driver.getPageSource(), expectedResult);
        } else {
            wait.until(ExpectedConditions.titleIs("百度一下，你就知道"));
            searchResultPageVerify(driver.getPageSource(), driver.getTitle());
        }
        driver.close();
    }

    private void searchResultPageVerify(String pageSource, String expectedKeywords) {
        assertTrue("testing pass", pageSource.contains(expectedKeywords));
    }
}

