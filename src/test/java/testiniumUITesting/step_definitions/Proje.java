package testiniumUITesting.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import testiniumUITesting.utilities.*;

import java.io.IOException;
import java.util.ArrayList;

public class Proje extends BaseStep {

    DataDriven dd = new DataDriven();
    ArrayList<String> list = dd.getData("Testinium");

    public Proje() throws IOException {
    }

    @Given("the customer gets on main page")
    public void the_customer_gets_on_main_page() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Open ::" + URL);
        BrowserUtils.wait(1);


    }

    @When("the customer write şort product name from excel")
    public void the_customer_write_şort_product_name_from_excel() throws IOException {


        String s = list.get(1);
        pages.mainPage().sendProductNameToSearchBox(s);


    }

    @When("the customer clean searchBox")
    public void the_customer_clean_search_box() {
        pages.mainPage().cleanProductName();

    }

    @When("the customer write gömlek product name from excel")
    public void the_customer_write_gömlek_product_name_from_excel() {
        String str = list.get(2);
        pages.mainPage().sendProductNameToSearchBox(str);

    }

    @When("the customer click on search box")
    public void the_customer_click_on_search_box() {
        pages.mainPage().clickOnSearchButton();

    }

    @When("the customer select one of products")
    public void the_customer_select_one_of_products() {
        pages.gömlekPage().clickOnProduct();

    }

    @When("the info about products written on file")
    public void the_info_about_products_written_on_file() {
        String s = pages.gömlekDetailsPage().writeGömlekDetails();
        WriteText.writeToFile("info.txt", s);


    }

    @When("the customer add to cart that product")
    public void the_customer_add_to_cart_that_product() {
        pages.gömlekDetailsPage().clickOnAddToCartButton();

    }

    @When("the customer compare price")
    public void the_customer_compare_price() {
        Assert.assertEquals(pages.gömlekDetailsPage().getGömlekDetailsPagePrice(), pages.cartPage().getCartPageGömlekPrice());

    }

    @When("the customer decrease the number of products")
    public void the_customer_decrease_the_number_of_products() {
        pages.cartPage().clickOnCountDropDownBox();
        pages.cartPage().selectCount();

    }

    @Then("the customer delete the products")
    public void the_customer_delete_the_products() {
        pages.cartPage().clickOnDeleteProductButton();

    }

    @Then("the customer control the cart empty or not")
    public void the_customer_control_the_cart_empty_or_not() {
        String s = pages.cartPage().getEmptyCartText();
        Assert.assertEquals("SEPETİNİZDE ÜRÜN BULUNMAMAKTADIR", s);

    }
}
