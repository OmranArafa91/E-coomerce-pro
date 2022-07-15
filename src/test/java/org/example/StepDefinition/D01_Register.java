package org.example.StepDefinition;

import org.example.Pages.Home_Page;
import org.example.Pages.Register_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {
    Register_Page register;
    Home_Page home;

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        register = new Register_Page(Hooks.driver);
        home = new Home_Page(Hooks.driver);
        home.Navigate_to_RegisterPage().click();
    }

    @And("user choose male or female")
    public void user_choose_Gender_Option (){
        register.genderType("female").click();
}

    @And("user enter valid data")
    public void user_enter_first_name(){
        register.firstName().sendKeys("Emran");

        register.lastName().sendKeys("Ali");

        Select selectday= new Select(register.day());
        selectday.selectByVisibleText("15");


        Select selectmonth= new Select(register.month());
        selectmonth.selectByIndex(1);


        Select selectyear= new Select(register.year());
        selectyear.selectByValue("1996");



        register.email().sendKeys("emran@gmail.com");

        register.companyName().sendKeys("Udacity");

        register.password().sendKeys("nopassword!");
        register.confirmPassword().sendKeys("nopassword!");
    }

    @Then("user click on register button")
    public void user_register_successfully(){
        register.registerB().click();
    }

    @And("user could register successfully")
    public void register_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successfulMsg().isDisplayed(), "Successful Message");
        // Second Assertion
        String actual = register.successfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "Message color");
        // Assert All
        soft.assertAll();
    }
}
