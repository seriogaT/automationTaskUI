package com.sample.tests.pages;

import com.sample.framework.Configuration;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import com.sample.framework.ui.controls.SelectList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by stovarnitchi on 8/10/2017.
 */
public class SearchPage extends Page {

    @FindBy(locator = "ss")
    public Edit editDestination;

    @FindBy(locator = "css=i.sb-date-field__chevron.bicon-downchevron")
    public Control checkoutDayExpand;

    @FindBy(locator = " //table[@class='c2-month-table']//td[contains(@class, 'c2-day-s-today'))]")
    public Control checkoutDayToday;

    @FindBy(locator = "xpath =(//input[@name='sb_travel_purpose'])[2]")
    public Control radioLeisure;

    @FindBy(locator = "xpath =(//input[@name='sb_travel_purpose'])[2]")
    public Control radioBusiness;

    @FindBy(locator = "group_adults")
    public SelectList selectAdultsNumber;

    @FindBy(locator = "xpath = //button[@type='submit']")
    public Control buttonSubmit;


    public SearchPage(WebDriver driver) {
        super(driver);

//        editDestination = new Edit(this, By.id("ss"));
//        checkoutDayExpand = new Control(this, By.cssSelector("i.sb-date-field__chevron.bicon-downchevron"));
//        checkoutDayToday = new Control(this, By.xpath("//table[@class='c2-month-table']//td[contains(@class, 'c2-day-s-today')]"));
//        radioLeisure = new Control(this, By.xpath("(//input[@name='sb_travel_purpose'])[2]"));
//        radioBusiness = new Control(this, By.xpath("(//input[@name='sb_travel_purpose'])[2]"));
//        selectAdultsNumber = new SelectList(this, By.id("group_adults"));
//        buttonSubmit = new Control(this, By.xpath("//button[@type='submit']"));

    }

    @Override

    public Page navigate() {
        String baseUrl = Configuration.get("url");
        this.getDriver().get(baseUrl);
        return this;
    }

    public void checkInToday() {
        checkoutDayExpand.click();
        checkoutDayToday.click();
    }

    public void selectTravelFor(boolean isLeisure) {
        if (isLeisure) {
            radioLeisure.click();
        } else {
            radioBusiness.click();
        }
    }
}
