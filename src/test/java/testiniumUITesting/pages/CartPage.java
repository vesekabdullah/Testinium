package testiniumUITesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[@class='m-productPrice__salePrice']")
    WebElement price;
    @FindBy(id = "quantitySelect0-key-0")
    WebElement countDropDown;
    @FindBy(id = "removeCartItemBtn0-key-0")
    WebElement deleteProductButton;

    @FindBy(xpath = "//strong[contains(text(),'Sepetinizde Ürün Bulunmamaktadır')]")
    WebElement emptyCartText;

    public String getCartPageGömlekPrice() {
        String prc = price.getText();
        return prc;
    }

    public void selectCount() {
        Select select = new Select(countDropDown);
        select.selectByVisibleText("2 adet");
    }

    public void clickOnCountDropDownBox() {
        countDropDown.click();
    }

    public void clickOnDeleteProductButton() {
        deleteProductButton.click();
    }

    public String getEmptyCartText() {

        String txt = emptyCartText.getText();
        return txt;

    }

}
