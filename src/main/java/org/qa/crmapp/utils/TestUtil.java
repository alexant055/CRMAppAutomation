package org.qa.crmapp.utils;

import org.qa.crmapp.base.Base;

public class TestUtil extends Base {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static void switchToFrame() {
        driver.switchTo().frame("downloadFrame");
    }
}
