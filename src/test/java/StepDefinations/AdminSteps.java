package StepDefinations;

import PageActions.BaseUtility;
import PageActions.LoginPage;
import PageActions.ViewSystemUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Properties;
import static Hooks.AppHooks.driver;
import static Hooks.AppHooks.prop;

public class AdminSteps{
    //public WebDriver driver;
    ViewSystemUser viewSystemUserObj;
    LoginPage loginPageObj;
    //public Properties prop;


    @Given("login to orangehrm web")
    public void login_to_orangehrm_web() throws InterruptedException, IOException {

        /*System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();*/

        loginPageObj = new LoginPage(driver);
        viewSystemUserObj = new ViewSystemUser(driver);

//        prop = new Properties();
//        FileInputStream fis = new FileInputStream("./src/test/config/config.proprties");
//        prop.load(fis);

        String usernameVariable = prop.getProperty("usernameKey");
        String passwordVariable = prop.getProperty("passwordKey");

        //Thread.sleep(2000);

        loginPageObj.enterUsername(usernameVariable);
        loginPageObj.enterPassword(passwordVariable);
        loginPageObj.clickOnLoginbtn();
        System.out.println("===Updated framework===");
    }

    @When("user navigate to admin section")
    public void user_navigate_to_admin_section() throws InterruptedException {
       // Thread.sleep(10000);
        viewSystemUserObj.clickAdminTab();
    }

    @When("user enter valid data")
    public void user_enter_valid_data() throws InterruptedException, IOException, ParseException {
        String jsonPath="./src/test/JsonTestData/UserData.json";
        JSONParser jsparser=new JSONParser();
        FileReader read=new FileReader(jsonPath);
        JSONObject jsonObject= (JSONObject) jsparser.parse(read);

        String nickname= (String) jsonObject.get("nickName");
        String admin= (String) jsonObject.get("roll");
        String empName= (String) jsonObject.get("empname");


        //Thread.sleep(2000);
        viewSystemUserObj.enterusername(nickname);
         //Thread.sleep(2000);
        viewSystemUserObj.selectuserroll(admin);
       // Thread.sleep(3000);
        viewSystemUserObj.enteremployeename(empName);
        //Thread.sleep(3000);
        viewSystemUserObj.selectuserstatus();
        //Thread.sleep(2000);
        viewSystemUserObj.entersearchbutton();
    }

    @Then("verify record found for valid data")
    public void verify_record_found_for_valid_data() {

    }

    @Then("logout from orangehrm")
    public void logout_from_orangehrm() {

    }
}
