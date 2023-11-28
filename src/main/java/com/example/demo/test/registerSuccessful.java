package com.example.demo.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;


public class registerSuccessful {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.edge.driver", "/Users/trinhdotuanminh/Downloads/msedgedriver.exe");
        WebDriver driver = new SafariDriver();

        //url web testing
        driver.get("http://localhost:8055/demo/login");
        driver.manage().window().setSize(new Dimension(1765, 1131));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("su")));
        signUpLink.click();

        // 4 | click | id=user-name |
        driver.findElement(By.id("user-name")).click();
        Thread.sleep(2000);

        // 5 | type | id=user-name | alex
        driver.findElement(By.id("user-name")).sendKeys("alex");
        Thread.sleep(2000);

        // 6 | click | id=user-pass |
        driver.findElement(By.id("user-pass")).click();
        Thread.sleep(2000);

        // 7 | type | id=user-pass | 1234
        driver.findElement(By.id("user-pass")).sendKeys("1234");
        Thread.sleep(2000);

        // 8 | click | id=user-repeatpass |
        driver.findElement(By.id("user-repeatpass")).click();
        Thread.sleep(2000);

        // 9 | type | id=user-repeatpass | 1234
        driver.findElement(By.id("user-repeatpass")).sendKeys("1234");
        Thread.sleep(2000);

        // 10 | click | css=.actual-form:nth-child(3) > .sign-btn |
        driver.findElement(By.cssSelector(".actual-form:nth-child(3) > .sign-btn")).click();

        //another way of doing
        //driver.findElement(By.xpath("//input[@value='Sign In' and @type='submit']")).click();
        //driver.close();

        String expected_title = "Trang chủ";
        String actual_title = driver.getTitle();

        if (expected_title.equalsIgnoreCase(actual_title)) {
            System.out.println("Register Successful");
        } else {
            System.out.println("Failed to register");
        }
    }
}


