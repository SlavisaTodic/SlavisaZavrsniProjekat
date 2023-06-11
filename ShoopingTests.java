package Test;

import org.junit.Test;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;

public class ShoopingTests extends BaseTest {
    
      public LoginPage loginPage;
      public HomePage homePage;
      public CheckoutPage checkoutPage;
      String standardUsername = "standard_user";
      String password = "secret_sauce";
      String homePageTitle = "Products";
      int numberOfAllItems = 6;
      String expectedAboutLink = "https://saucelabs.com/";
      String firstname = "Slavisa";
      String lastname = "Todic";
      String zipcode = "1234";
      String shoopingPageTitle = "Thank you for your order!";
      
      

@Test
public void verifySuccesfulAddToCart(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductAddedToCart();
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void numberOfItemsHomePage(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.numberOfProducts(numberOfAllItems);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verfySuccessfulShooping(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.clickOnCartButton();
    checkoutPage.clickOnCheckoutButton();
    checkoutPage.verifySuccessfullLoginCheckout(firstname, lastname, zipcode);
    checkoutPage.clickOnContinueButton();
    checkoutPage.clickOnFinishButton();
    checkoutPage.verifySuccesfulShooping(shoopingPageTitle);
    

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}


}
