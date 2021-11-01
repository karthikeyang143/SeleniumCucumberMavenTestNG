package com.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class YouTubeSearchStepDef {
    public static WebDriver driver;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("Open the browser and navigate to URL")
    public void LaunchBrowserAndNavigate()
    {
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()='I agree']")).click();
        Assert.assertTrue(driver.getTitle().equals("YouTube"));
    }

    @When("I enter the search criteria")
    public void IEnterTheSearchCriteria() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Automation Testing");
    }
    @Then("I Click on search button")
    public void IClickonsearchbutton()
    {
        driver.findElement(By.id("search-icon-legacy")).click();
        driver.close();
    }
}