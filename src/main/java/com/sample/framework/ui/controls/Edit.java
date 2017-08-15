package com.sample.framework.ui.controls;

import com.sample.framework.ui.Page;
import org.openqa.selenium.By;

/**
 * Created by stovarnitchi on 8/8/2017.
 */
public class Edit extends Control {
    public Edit(Page parentValue, By locatorValue){
        super(parentValue,locatorValue);
    }
    public void setText (String value){
        this.click();
        this.element().clear();
        this.element().sendKeys(value);
    }
}
