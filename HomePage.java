package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }

    By homePageTitleBy = By.className("title");
    By addToCartButtonBy1 = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButtonBy2 = By.id("add-to-cart-sauce-labs-bike-light");
    By shoopingCartBadgeBy = By.className("shopping_cart_badge");
    By numberOfItems = By.className("inventory_item");
    By menuButtonBy = By.className("bm-burger-button");
    By aboutButtonBy = By.id("about_sidebar_link");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By cartButtonBy = By.id("shopping_cart_container");
    
    

    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyProductAddedToCart (){
        click(addToCartButtonBy1);
        click(addToCartButtonBy2);
        waitVisability(shoopingCartBadgeBy);
        return this;
    }

    public HomePage numberOfProducts (int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfItems);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage clickOnMenuButton(){
        click(menuButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton(){
        click(logoutButtonBy);
        return this;

    }

    public HomePage clickOnCartButton(){
        click(cartButtonBy);
        return this;

    }


    

    

        
}

