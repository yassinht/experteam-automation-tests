package com.expert.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.ConfigReader;

public class HomeTest {

    WebDriver driver;
    HomePage homePage;


    @Before
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));
        homePage= new HomePage(driver);


    }

    @Test
    public void openHomePage() {
        System.out.println(driver.getTitle());
    }
    
    @Test
    public void verifyHomeElements() throws Exception {

        Assert.assertTrue(homePage.isLogoDisplayed());
        System.out.println("logo:");
        System.out.println(homePage.isemailDisplayed());
        Assert.assertEquals("+216 29 674 204",homePage.getPhone1());
        Assert.assertEquals("+216 29 674 575",homePage.getPhone2());
        Assert.assertTrue(homePage.isemailDisplayed());
        System.out.println("email:");
        System.out.println(homePage.isemailDisplayed());

    }
    
  @Test 
  public void verifyTags() {

     List<WebElement> tags = homePage.getTags();    
     System.out.println("Total tags = " + tags);

      boolean found = false;

      for (WebElement tag : tags) {
          System.out.println(tag.getText());

          if (tag.getText().equals("#Selenium")) {
              found = true;
          }
      }

      Assert.assertTrue(found);

  }
    @After
    public void tearDown() {
        driver.quit();
    }
}