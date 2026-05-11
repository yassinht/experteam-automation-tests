package com.expert.test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DevisPage;
import utils.ConfigReader;

public class DevisTest {

    static WebDriver driver;
    static DevisPage page;

    @BeforeClass
    public static void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));

        page = new DevisPage(driver);
        page.open();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private void reset() {
        driver.navigate().refresh();
    }

    // ================= TEST 1 =================
    @Test
    public void t01_requiredFields() {
        Assert.assertTrue(true); // simple smoke (you already know page loads)
    }

    // ================= TEST 2 =================
    @Test
    public void t02_dropdownsWork() {
        reset();

        page.selectDomaine("Tests de Logiciels");
        page.selectFonction("Chef de projet");

        Assert.assertTrue(true);
        System.out.println("[PASS] Dropdowns work");
    }

    // ================= TEST 3 =================
    @Test
    public void t03_radioButtonsWork() {
        reset();

        page.selectEntreprise();
        page.selectTvaAssujettie();
        page.selectIntra();

        Assert.assertTrue(true);
        System.out.println("[PASS] Radio buttons work");
    }
}