package com.sample.tests;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;

import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.SearchPage;
import com.sample.tests.pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Arrays;
import java.util.Collection;

/**
 * Created by stovarnitchi on 8/8/2017.
 */

@RunWith(Parameterized.class)

public class BookingSearchTest {
    private WebDriver driver;
    private String destination;
    private boolean isLeisure;
    private int numberOfAdults;

    private SearchPage searchPage;
    private SearchResultsPage searchResultsPage;

    public BookingSearchTest(String destination, boolean isLeisure, int numberOfAdults) {
        super();
        this.destination = destination;
        this.isLeisure = isLeisure;
        this.numberOfAdults = numberOfAdults;
    }


    @Before
    public void setUp() throws Exception {
        Configuration.load();
        Configuration.print();
        String baseUrl = Configuration.get("url");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\stovarnitchi\\geckodriver\\geckodriver.exe");

        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"), cap);

//       DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability("marionette", false);
//        driver=Driver.current();
        driver = new FirefoxDriver(cap);
        //   driver.get(baseUrl);
        searchPage = PageFactory.init(SearchPage.class);
        searchPage.navigate();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(
                new Object[][]{
                        {"london", true, 2},
                        {"manchester", false, 1},
                });
    }

    @Test
    public void testValidSearch() throws Exception {

        searchPage.editDestination.setText(destination);
        searchPage.checkoutDayExpand.click();
        searchPage.checkoutDayToday.click();

        searchPage.selectTravelFor(isLeisure);
        searchPage.selectAdultsNumber.selectByText("" + numberOfAdults);
        searchPage.buttonSubmit.click();

        searchResultsPage = PageFactory.init(SearchResultsPage.class);
        searchResultsPage.editDestination.click();
        searchResultsPage.isTextPresent(destination);
        searchResultsPage.captureScreenShot("./build/image01.png");

//
////new
//        Edit editDestination = new Edit(driver,By.id("ss"));
//        Control checkoutDayExpand = new Control(driver, By.cssSelector("i.sb-date-field__chevron.bicon-downchevron"));
//        Control checkoutDayToday = new Control(driver, By.xpath("//table[@class='c2-month-table']//td[contains(@class, 'c2-day-s-today')]"));
//        Control radioLeisure = new Control(driver, By.xpath("(//input[@name='sb_travel_purpose'])[2]"));
//        Control radioBusiness = new Control(driver, By.xpath("(//input[@name='sb_travel_purpose'])[2]"));
////        Control radioHotels = new Control(driver, By.xpath("(//input[@name='nflt'])[2]"));
//        SelectList selectAdultsNumber = new SelectList(driver, By.id("group_adults"));
//        Control buttonSubmit = new Control(driver, By.xpath("//button[@type='submit']"));
//
//        editDestination.setText(this.destination);
//        checkoutDayExpand.click();
//        checkoutDayToday.click();
//        if(this.isLeisure){
//            radioLeisure.click();
//        }else{
//            radioBusiness.click();
//        }
////        radioHotels.click();
//        selectAdultsNumber.selectByText(""+this.numberOfAdults);
//        buttonSubmit.click();
//        editDestination.click();
//
//
////        driver.findElement(By.id("ss")).click();
////        driver.findElement(By.id("ss")).clear();
////        driver.findElement(By.id("ss")).sendKeys("london");
////        driver.findElement(By.cssSelector("i.sb-date-field__chevron.bicon-downchevron")).click();
////        driver.findElement(By.xpath("//table[@class='c2-month-table']//td[contains(@class, 'c2-day-s-today')]")).click();
////        driver.findElement(By.xpath("(//input[@name='sb_travel_purpose'])[2]")).click();
////        driver.findElement(By.id("no_rooms")).click();
////        new Select(driver.findElement(By.id("no_rooms"))).selectByVisibleText("2");
////        driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
////        driver.findElement(By.id("group_adults")).click();
////        driver.findElement(By.cssSelector("#group_adults > option[value=\"2\"]")).click();
////        driver.findElement(By.xpath("//button[@type='submit']")).click();
////        driver.findElement(By.xpath("//form[@id='frm']/div[6]")).click();
//
//
//
////old
////        driver.findElement(By.id("ss")).click();
////        driver.findElement(By.id("ss")).clear();
////        driver.findElement(By.id("ss")).sendKeys("london");
////        driver.findElement(By.cssSelector("i.sb-date-field__chevron.bicon-downchevron")).click();
////        driver.findElement(By.xpath("//table[@class='c2-month-table']//td[contains(@class, 'c2-day-s-today')]")).click();
////        driver.findElement(By.xpath("(//input[@name='sb_travel_purpose'])[2]")).click();
////        driver.findElement(By.id("no_rooms")).click();
////        new Select(driver.findElement(By.id("no_rooms"))).selectByVisibleText("2");
////        driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
////        driver.findElement(By.id("group_adults")).click();
////        driver.findElement(By.cssSelector("#group_adults > option[value=\"2\"]")).click();
////        driver.findElement(By.xpath("//button[@type='submit']")).click();
////        driver.findElement(By.xpath("//form[@id='frm']/div[6]")).click();click
    }
}
