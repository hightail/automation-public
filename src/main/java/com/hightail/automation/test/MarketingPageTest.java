package com.hightail.automation.test;

import com.hightail.automation.test.base.BaseTest;
import com.hightail.automation.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by shiva.paranandi on 3/22/17.
 */

public class MarketingPageTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketingPageTest.class);

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        LOGGER.info("Inside setUp");
    }

    @AfterClass
    public void tearDown() throws Exception {
        LOGGER.info("Inside tearDown");
    }

    @BeforeMethod
    public void setUpTest() throws Exception {
        LOGGER.info("Inside setUpTest");

        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();

        //Launch the Online Website
        driver.get(configuration.getBaseURL());
    }

    @AfterMethod
    public void tearDownTest() throws Exception {
        LOGGER.info("Inside tearDownTest");
        driver.close();
        driver.quit();
    }

    @Test(description="Launches the marketing site")
    public void testIntegration() throws Exception {
        LOGGER.info("Inside testIntegration");

        String signInTxt = driver.findElement(By.className("main-nav-link")).getText();
        Assert.assertEquals(signInTxt, "Features");
    }
}