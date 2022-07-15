package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Register_Page {
    WebDriver driver;

    public Register_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement Navigate_to_RegisterPage() {
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }
//****************************************
public WebElement genderType(String type)
{
    WebElement element = null;

    if (type.equals("male")) {
        element = Hooks.driver.findElement(By.id("gender-male"));
    }
    else if(type.equals("female")) {
        element = Hooks.driver.findElement(By.id("gender-female"));

    }
    return element;

}
//*************************************

    public WebElement firstName()
    {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName()
    {
        return driver.findElement(By.id("LastName"));
    }



   public WebElement day(){
        WebElement day= Hooks.driver.findElement(By.name("DateOfBirthDay"));
       return day;
   }
    public WebElement month(){
        WebElement month= Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        return month;
    }
    public WebElement year(){
        WebElement year= Hooks.driver.findElement(By.name("DateOfBirthYear"));
        return year;
    }
    public WebElement email()
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement companyName()
    {
        return driver.findElement(By.id("Company"));
    }

    public WebElement password()
    {
        return driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerB()
    {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement successfulMsg()
    {
        return driver.findElement(By.xpath("//div[@class=\"result\"]"));
    }


}
