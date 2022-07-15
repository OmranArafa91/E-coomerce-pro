package org.example.StepDefinition;

import io.cucumber.java.en.Given;
import org.example.Pages.Home_Page;
import org.example.Pages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_Login {
    Login_Page login;
    Home_Page home;

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {
        home = new Home_Page(Hooks.driver);
        login = new Login_Page(Hooks.driver);
        home.Navigate_to_LoginPage().click();
    }

    @And("user enter \"(.*)\" and \"(.*)\"$")
    public void vaild_data(String email, String password) throws InterruptedException {
        login.LoginSteps(email, password);
        Thread.sleep(1000);
    }

    @And("user click on login button")
    public void click_Login() {
        login.passwordE().sendKeys(Keys.ENTER);
    }

    @Then("user could login successfully and go to home page")
    public void login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/","URL after login");
        // Second Assertion
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        soft.assertTrue(login.myAccount().isDisplayed(), "My Account");
        // Assert All
        soft.assertAll();
    }
}
