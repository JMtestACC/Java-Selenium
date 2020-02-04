import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    @FindBy(xpath = "//a[.='Sign In']")
    private WebElement signOnLink;

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInLink(){
        signOnLink.click();
    }

}