package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class MyAccountsTest extends BaseTest {
    String email;
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        registerPage.enterFirstName("Ravina");
        //3.4 Enter Last Name
        registerPage.enterLastName("Pansuriya");
        //3.5 Enter Email
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        registerPage.enterEmail(email);
        //3.6 Enter Telephone
        registerPage.enterPhoneNumber("0791799534567");
        //3.7 Enter Password
        registerPage.enterPassword("Ravina1234");
        //3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("Ravina1234");
        //3.9 Select Subscribe Yes radio button
        registerPage.selectSubscribeButton("Yes");
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnAgree();
        //3.11 Click on Continue button
        registerPage.clickOnContinue();
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = registerPage.getAccountCreatedText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.13 Click on Continue button
        registerPage.clickOnContinueAfterCreation();
        //3.14 Click on My Account Link.
        homePage.clickOnMyAccountAfterLogin();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //String option = "Logout";
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.17 Click on Continue button
        registerPage.clickOnContinueAfterCreation();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        loginPage.enterEmailId("ravina123@gmail.com");
        //4.5 Enter Password
        loginPage.enterPassword("Ravina1234");
        //4.6 Click on Login button
        loginPage.clickOnLogin();
        //4.7 Verify text “My Account”
        String expectedMessage = "My Account";
        String actualMessage = loginPage.getMyAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //4.8 Click on My Account Link.
        homePage.clickOnMyAccountAfterLogin();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        String option = "Logout";
        myAccountPage.selectMyAccountOptions(option);
        //4.10 Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //4.11 Click on Continue button
        registerPage.clickOnContinueAfterCreation();
    }
}
