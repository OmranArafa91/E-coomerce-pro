package org.example.StepDefinition;

import org.example.Pages.Home_Page;
import org.example.Pages.Wishlist_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishList {
    Wishlist_Page wishpage;
    Home_Page homepage;
    int num;
    @Given("add item to wishlist")
    public void user_add_item_to_wishlist() {
        homepage = new Home_Page(Hooks.driver);
        wishpage = new Wishlist_Page(Hooks.driver);
        homepage.addWishList().get(2).click();
    }

    @Then("wishlist notification success is displayed")
    public void successNotification() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homepage.wishSuccessMsg().isDisplayed(), "Success Message displayed");

        String actual = homepage.wishSuccessMsg().getCssValue("background-color");
        String expected = "rgba(75, 176, 122, 1)";
        soft.assertEquals(actual, expected, "Success Message color");
    }

    @And("user get the number of wishlist items after adding item")
    public void itemsIncreased() {
        String text = homepage.wishList().getText();
        text = text.replaceAll("[^0-9]", "");
        num = Integer.parseInt(text);
    }

    @Then("the number of wishlist increased")
    public void number_of_items_of_wishlist() throws InterruptedException {
        Assert.assertTrue(num > 0, "wishlist increased");
    }

    @And("user go to wishlist page")
    public void user_go_to_wishlist() throws InterruptedException {
        homepage.closeB().click();
        Thread.sleep(2000);
        homepage.wishList().click();
    }

    @Then("the number of items greater than zero in wishlist page")
    public void wishlistPage_Assertion() {

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/wishlist"), "URL after click on wishlist");

        int size = wishpage.wishListItems();
        soft.assertTrue(size > 0,"Items of wishlist");

        soft.assertAll();
    }
}
