package WikipediaTest;

import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Wikipedia Automation Testing by Barış Can Bilgin")
public class WikipediaTest {

    WebDriver driver;
    int waitTime = 1000;
    String userName = "QA-Testing-BCB";
    String wrongUserName = "WrongUsername-QA-Testing-BCB";

    @BeforeMethod
    public void OpenBrowser() {
        driver = new EdgeDriver();
        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();

    }

    public void GoToLoginPage() throws InterruptedException {

        driver.findElement(By.id("js-link-box-en")).click();
        Thread.sleep(waitTime);

        WebElement loginContainer = driver.findElement(By.id("pt-login-2"));
        loginContainer.findElement(By.cssSelector("a")).click();
    }


    @Test(description = "Successful Login Test")
    public void SuccessfulLogin() throws InterruptedException {

        GoToLoginPage();

        driver.findElement(By.id("wpName1")).sendKeys(userName);
        Thread.sleep(waitTime);
        driver.findElement(By.id("wpPassword1")).sendKeys("QA-test123");
        Thread.sleep(waitTime);
        driver.findElement(By.id("wpLoginAttempt")).submit();
        Thread.sleep(waitTime);
        System.out.println("Passed Login Test.");
    }

    @Test(description = "Wrong Username Test")
    public void WrongEmailLogin() throws InterruptedException {

        GoToLoginPage();

        driver.findElement(By.id("wpName1")).sendKeys(wrongUserName);
        Thread.sleep(waitTime);
        driver.findElement(By.id("wpPassword1")).sendKeys("test-123");
        Thread.sleep(waitTime);
        driver.findElement(By.id("wpLoginAttempt")).submit();
        Thread.sleep(waitTime);
        System.out.println("Passed Wrong E-Mail Test");
    }

    @Test(description = "Wrong Password Test")
    public void WrongPasswordLogin() throws InterruptedException {

        GoToLoginPage();

        driver.findElement(By.id("wpName1")).sendKeys(userName);
        Thread.sleep(waitTime);
        driver.findElement(By.id("wpPassword1")).sendKeys("wrongPassword");
        Thread.sleep(waitTime);
        driver.findElement(By.id("wpLoginAttempt")).submit();
        Thread.sleep(waitTime);
        System.out.println("Passed Wrong Password Test.");


    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

}
