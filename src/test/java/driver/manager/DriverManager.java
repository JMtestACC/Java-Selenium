package driver.manager;

import configuration.ConfigurationProperties;
import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;
        if(browserType == null) {
            browserType = BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
            browser = new BrowserFactory(browserType).getBrowser();
        } else {
            browser = new BrowserFactory(browserType).getBrowser();
        }

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {
        if(webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        if(!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}
