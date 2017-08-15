package com.sample.tests.pages;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;

/**
 * Created by stovarnitchi on 8/10/2017.
 */
public class SearchResultsPage extends Page {
    @FindBy(locator = "ss")
    public Edit editDestination;

    public SearchResultsPage(WebDriver driverValue) {
        super(driverValue);
    }
}
