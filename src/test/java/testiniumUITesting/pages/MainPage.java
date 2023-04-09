package testiniumUITesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "input[placeholder='Ürün, Marka Arayın']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[normalize-space()='ARA']")
    private WebElement searchButton;

    public void sendProductNameToSearchBox(String productName) {
        searchBox.sendKeys(productName);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void cleanProductName() {
        searchBox.clear();
    }

}
