package Base;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected  WebDriver driver;
    protected LoginPage loginPage;


    @BeforeMethod
    public void Openbrowser() {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage= new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void shutdown() {
        if (driver != null) {
            driver.quit();
        }
}}



