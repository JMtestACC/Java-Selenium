package driver;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    private BrowserType browserType;

    public BrowserFactory(BrowserType browserType) {
        this.browserType = browserType;
    }

    public WebDriver getBrowser() {
        switch (browserType) {
            case CHROME:
//                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", LocalWebDriverProperties.getInternetExplorerWebDriverLocation());
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check configuration");
        }
    }

}
