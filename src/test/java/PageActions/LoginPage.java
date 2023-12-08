package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseUtility {
   // public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement Uname;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement Passwrd;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement LoginBtn;

    public void enterUsername(String username){
        //Uname.sendKeys(username);
        waitClearEnterText(Uname,username);
    }

    public void enterPassword(String password){
        Passwrd.sendKeys(password);
    }

    public void clickOnLoginbtn(){
        //clickOnWebElementHelper(LoginBtn);
        LoginBtn.click();
    }
}
