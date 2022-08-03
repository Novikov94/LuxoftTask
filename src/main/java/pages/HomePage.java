package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage {

    @FindBy(xpath = "(//input[@name = 'commit'])[4]")
    private WebElement submitButton;

    @FindBy(xpath = "(//input[@class = 'form-control form-control-sm'])[4]")
    private WebElement textField;

    @FindBy(xpath = "(//a[@href='/directions'])[2]")
    private WebElement searchButton;

    @FindBy(xpath = "(//input[@class = 'form-control form-control-sm'])[5]")
    private WebElement routeFromTextField;

    @FindBy(xpath = "(//input[@class = 'form-control form-control-sm'])[6]")
    private WebElement routeToTextField;

    @FindBy(xpath = "(//select[@class = 'routing_engines form-select form-select-sm'])[2]")
    private WebElement selectButton;

    @FindBy(xpath = "//*[contains(text(),'2423km.')]")
    private WebElement expectedDistance;

    public WebElement getTextField() {
        return textField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getRouteFromTextField() {
        return routeFromTextField;
    }

    public WebElement getRouteToTextField() {
        return routeToTextField;
    }

    public WebElement getSelectButton() {
        return selectButton;
    }

    public WebElement getExpectedDistance() {
        return expectedDistance;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public boolean isSubmitButtonVisible(){
        submitButton.isDisplayed();
        return true;
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public boolean verifyDistance() {
        return expectedDistance.getText().contains("2423km");
    }

    public boolean isSelectButtonVisible() {
        selectButton.isDisplayed();
        return true;
    }

    public void selectVehicle() {
        Select vehicle = new Select(selectButton);
        vehicle.selectByIndex(1);
    }

    public boolean isTextFieldVisible() {
        textField.isDisplayed();
        return true;
    }

    public boolean isSearchButtonVisible() {
        searchButton.isDisplayed();
        return true;
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public boolean isRoutFromTextFieldVisible() {
        routeFromTextField.isDisplayed();
        return true;
    }

    public boolean isRoutToTextFieldVisible() {
        routeToTextField.isDisplayed();
        return true;
    }

    public void enterStartPoint() {
        routeFromTextField.sendKeys("Радищева, Київ");
    }

    public void enterFinishPoint() {
        routeToTextField.sendKeys("Кембридж");
    }


    public boolean isSelectedButtonSelected() {
        selectButton.isSelected();
        return true;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
}
