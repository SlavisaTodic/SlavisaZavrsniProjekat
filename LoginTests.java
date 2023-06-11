package Test;
import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String suspendedUser = "locked_out_user";
    String suspendedUserErorr = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUsername = "Pogresan username";
    String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    String invalidPassword = "Pogresan password";

@Test
public void verifySuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifySuspendedUser(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(suspendedUser, password);
    loginPage.verifyUnsuccessfulLogin(suspendedUserErorr);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccessfulLogin(emptyUsernameError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccessfulLogin(emptyPasswordError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test
public void verifyUnsuccessfulInvalidUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUsername, password);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulInvalidPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, invalidPassword);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
@Test
public void verifySuccessfulLogout(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.clickOnMenuButton();
    homePage.clickOnLogoutButton();
    loginPage.verifyLogout();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}