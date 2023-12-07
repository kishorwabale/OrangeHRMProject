package PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUser extends BaseUtility {

    //public WebDriver driver;
    // private String ename;

    public ViewSystemUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminTab;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement entusername;

    @FindBy(xpath = "//label[text()='User Role']/following::div[1]")
    private WebElement userrole;

    @FindBy(xpath = "(//span[text()='Admin'])[2]")
    private WebElement selectAdmin;

    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    private WebElement enterempname;

    @FindBy(xpath = "//div[@role=\"option\"]//span[text()='Virat  Kohli']")
    private WebElement uservirat;

    @FindBy(xpath = "//label[text()='Status']/following::div[1]")
    private WebElement userstatus;

    @FindBy(xpath = "//span[text()='Enabled']")
    private WebElement usrenale;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitsearch;

    public void clickAdminTab() throws InterruptedException {
//        click(adminTab);
        //Thread.sleep(5000);
        jsClick(adminTab);
        //adminTab.click();
        System.out.println("===clicked on Admin Tab====");
    }

    public void enterusername(String nickname) {
        //entusername.sendKeys(nickname);
        waitClearEnterText(entusername, nickname);
    }

    public void selectuserroll(String admin) {
        userrole.click();
        selectAdmin.click();
    }

    public void enteremployeename(String ename) throws InterruptedException {
        enterempname.sendKeys(ename);
        //Thread.sleep(4000);
        click(uservirat);
        //uservirat.click();
    }

    public void selectuserstatus() throws InterruptedException {
        userstatus.click();
        click(usrenale);
        //Thread.sleep(2000);
        //usrenale.click();
    }

    public void entersearchbutton() {
        submitsearch.click();
    }
}

