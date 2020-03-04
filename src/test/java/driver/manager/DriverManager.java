package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if(webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser()));
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        if(!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
    }
}
