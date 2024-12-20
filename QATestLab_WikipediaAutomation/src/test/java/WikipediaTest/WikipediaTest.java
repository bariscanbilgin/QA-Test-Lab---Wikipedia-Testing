package WikipediaTest;

import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Wikipedia Automation Testing by Barış Can Bilgin")
public class WikipediaTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        driver = new EdgeDriver();
        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();
    }

    @Test(description = "Successful Login Test")
    public void SuccessfulLogin() throws InterruptedException {
        driver.findElement(By.id("js-link-box-en")).submit();
        Thread.sleep(500);

        driver.findElement(By.id("jpt-login-2")).submit();
        Thread.sleep(500);

        driver.findElement(By.id("edit-name")).sendKeys("QA-Testing-BCB@yandex.com");
        Thread.sleep(500);
        driver.findElement(By.id("edit-pass")).sendKeys("test-123");
        Thread.sleep(500);
        driver.findElement(By.id("edit-submit")).submit();
        System.out.println("Passed Login Test.");
    }

    @Test(description = "Wrong E-Mail Test")
    public void WrongEmailLogin() throws InterruptedException {
        driver.findElement(By.id("edit-name")).sendKeys("wrongmail@mail.com");
        Thread.sleep(500);
        driver.findElement(By.id("edit-pass")).sendKeys("test-123");
        Thread.sleep(500);
        driver.findElement(By.id("edit-submit")).submit();
        Thread.sleep(500);
        System.out.println("Passed Wrong E-Mail Test");
    }

    @Test(description = "Wrong Password Test")
    public void WrongPasswordLogin() throws InterruptedException {
        driver.findElement(By.id("edit-name")).sendKeys("QA-Testing-BCB@yandex.com");
        Thread.sleep(500);
        driver.findElement(By.id("edit-pass")).sendKeys("wrongPassword");
        Thread.sleep(500);
        driver.findElement(By.id("edit-submit")).submit();
        Thread.sleep(500);
        System.out.println("Passed Wrong Password Test.");


    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

}
