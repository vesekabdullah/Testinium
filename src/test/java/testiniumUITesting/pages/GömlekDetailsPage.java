package testiniumUITesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GömlekDetailsPage extends BasePage {
    @FindBy(xpath = "//div[@class='m-productDescription__infoList col-8']//div[1]//div[2")
    WebElement gömlekDetails;
    @FindBy(id = "#priceNew")
    WebElement price;
    @FindBy(id = "addBasket")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[normalize-space()='S']")
    WebElement sSizeBox;
    @FindBy(css = "a[title='Sepetim']")
    WebElement myCartButton;


    public String writeGömlekDetails() {
        String details = gömlekDetails.getText();
        return details;
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public String getGömlekDetailsPagePrice() {
        String prc = price.getText();
        return prc;

    }

    public void clickOnSSizeBox() {
        sSizeBox.click();
    }

    public void clickOnMyCartButton() {
        myCartButton.click();
    }


}
