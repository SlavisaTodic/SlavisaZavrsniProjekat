package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage (WebDriver driver){
        super(driver);
    }

    By checkoutButtonBy = By.id("checkout");
    By firstnameBy = By.id("first-name");
    By lastnameBy = By.id("last-name");
    By zipcodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By finishButtonBy = By.id("finish");
    By shoopingPageTitleBy = By.className("complete-header");
    

    public CheckoutPage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this;

    }
    public CheckoutPage clickOnContinueButton(){
        click(continueButtonBy);
        return this;
    }

    public CheckoutPage clickOnFinishButton(){
        click(finishButtonBy);
        return this;
    }

    public CheckoutPage verifySuccessfullLoginCheckout (String firstname, String lastname, String zipcode){
        writeText(firstnameBy, firstname);
        writeText(lastnameBy, lastname);
        writeText(zipcodeBy, zipcode);
        return this;
    }

    public CheckoutPage verifySuccesfulShooping(String expectedText){
        String actualText = readText(shoopingPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

}
