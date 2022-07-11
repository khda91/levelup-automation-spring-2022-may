package ru.levelp.at.lesson12.design.patterns.singleton;

import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverSingletonCloseTest {

    @Test
    public void webDriverSingletonCloseTest() {
        WebDriverSingleton wds = WebDriverSingleton.getInstance();
        System.out.println("webDriverSingletonCloseTest -> " + wds.getDriver().getWindowHandles());
        wds.getDriver().quit();
        SleepUtils.sleep(2500);
    }
}
