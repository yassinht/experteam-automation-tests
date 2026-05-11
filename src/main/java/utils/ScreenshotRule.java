package utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

public class ScreenshotRule implements TestRule {

    private WebDriver driver;

    public ScreenshotRule(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate(); // run test
                } catch (Throwable t) {
                    ScreenshotUtil.takeScreenshot(driver, description.getMethodName());
                    throw t;
                }
            }
        };
    }
}