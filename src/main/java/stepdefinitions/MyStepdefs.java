package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class MyStepdefs {

    private static final long DEFAULT_TIMEOUT = 100;
    private static final String START_POINT = "Радищева, Київ";
    private static final String FINISH_POINT = "Кембридж";


    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("Open {string} of website")
    public void openHomePageOfWebsite(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getTextField());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSearchButton());
        Assert.assertTrue(homePage.isTextFieldVisible());
        Assert.assertTrue(homePage.isSearchButtonVisible());
    }

    @When("user clicks on the search button")
    public void userClicksOnTheSearchButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSearchButton());
        homePage.searchButtonClick();
        Assert.assertTrue(homePage.isRoutFromTextFieldVisible());
        Assert.assertTrue(homePage.isRoutToTextFieldVisible());
    }

    @And("user enters {string} and {string}")
    public void userEntersStartPointAndFinishPoint(String start_point, String finish_point) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getRouteFromTextField());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getRouteToTextField());
        homePage.enterStartPoint();
        homePage.enterFinishPoint();
    }


    @And("user select {string}")
    public void userSelectVehicle(String SELECTED_VEHICLE) {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSelectButton());
        homePage.isSelectButtonVisible();
        homePage.selectVehicle();
        Assert.assertTrue(homePage.isSelectedButtonSelected());
    }

    @And("user clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSubmitButton());
        homePage.clickSubmitButton();
    }

    @Then("check that distance between two point is {int}km.")
    public void checkThatDistanceBetweenTwoPointIsKm(int distance) {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getExpectedDistance());
        Assert.assertTrue(homePage.verifyDistance());
    }
}
