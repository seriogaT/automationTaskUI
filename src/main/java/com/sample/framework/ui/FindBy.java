package com.sample.framework.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by stovarnitchi on 8/11/2017.
 *
 */

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FindBy {
    String locator();
}
