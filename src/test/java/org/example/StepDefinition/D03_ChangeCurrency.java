package org.example.StepDefinition;

import org.example.Pages.Home_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.SwitchCurrencyPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D03_ChangeCurrency {

    SwitchCurrencyPage currencypage ;

    @When("user select “Euro” from currency dropdown list")
    public void user_select_Euro()  {
        currencypage = new SwitchCurrencyPage(Hooks.driver);
        currencypage.currency().click();
        currencypage.currencyEuro().click();
    }

    @Then("euro is selected successfully")
    public void euro_is_selected_successfully()  {
     int count =Hooks.driver.findElements(
      By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).size();
        for(int i=0;i<count;i++){
    String selected = Hooks.driver.findElement(By.cssSelector("span[class=\"price actual-price\"]")).getText();
    Assert.assertTrue(selected.contains("€"), "euro selected successfully");
}

    }}
/*
    @Then("user select “usd” from currency dropdown list")
    public void user_select_Dollar() throws InterruptedException {
        currency.choose_US();
        Thread.sleep(1000);
    }

    @Then("usd is selected successfully")
    public void usd_is_selected_successfully() throws InterruptedException {
        String selected = Hooks.driver.findElement(By.id("customerCurrency")).getText();
        Assert.assertTrue(selected.contains(""), "usd selected successfully");
        currency.currencyUSD();
        Thread.sleep(1000);
    }
    */

