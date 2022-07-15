package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static org.example.StepDefinition.Hooks.driver;

public class SwitchCurrencyPage {
    WebDriver driver;

    public SwitchCurrencyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement currency() {
        return driver.findElement(By.id("customerCurrency"));
    }

    public WebElement currencyEuro() {
        return driver.findElement(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
    }
}
  /*  public WebElement choose_Euro()
    {
        By Euro= By.id("customerCurrency");
        WebElement choose_Euro= driver.findElement(Euro);
        Select selectObject = new Select(choose_Euro);
        selectObject.selectByVisibleText("Euro");
        return choose_Euro;
    }
    public WebElement choose_US()
    {
        By US= By.id("customerCurrency");
        WebElement choose_US= driver.findElement(US);
        Select selectObject2 = new Select(choose_US);
        selectObject2.selectByVisibleText("US Dollar");
        return choose_US;
    }

  /*  public List<WebElement> currencyEuro(){
        int count = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
        for(int i=0; i<count; i++){
            String actual =Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(i).getText();
            String expected= "€";
            Assert.assertTrue(actual.contains(expected),"error currency");
        }
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));

    }
    public List<WebElement> currencyUSD(){
        int count = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
        for(int i=0; i<count; i++){
            String actual =Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(i).getText();
            String expected= "$";
            Assert.assertTrue(actual.contains(expected),"error currency");
        }
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));

    }*/


