package testiniumUITesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GömlekPage extends BasePage {

    @FindBy(className = ".col-sm-4")
    private WebElement someGömlek;

    public void clickOnProduct() {
        someGömlek.click();

    }


}
