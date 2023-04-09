package testiniumUITesting.utilities;


import testiniumUITesting.pages.*;

public class Pages {

    private CartPage cartPage;
    private GömlekDetailsPage gömlekDetailsPage;
    private GömlekPage gömlekPage;
    private MainPage mainPage;


    public Pages() {
        this.cartPage = new CartPage();
        this.gömlekDetailsPage = new GömlekDetailsPage();
        this.gömlekPage = new GömlekPage();
        this.mainPage = new MainPage();
    }

    public CartPage cartPage() {
        return cartPage;
    }

    public GömlekDetailsPage gömlekDetailsPage() {
        return gömlekDetailsPage;
    }

    public GömlekPage gömlekPage() {
        return gömlekPage;
    }

    public MainPage mainPage() {
        return mainPage;
    }


}
