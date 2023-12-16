package com.example.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.Dimension;

public class registerTest {
    public static void main(String[] args) throws Exception {
        // System.setProperty("webdriver.edge.driver",
        // "/Users/trinhdotuanminh/Downloads/msedgedriver.exe");
        WebDriver driver = new SafariDriver();

        // url web testing
        driver.get("http://localhost:8055/demo/login-test");
        driver.manage().window().setSize(new Dimension(1211, 896));

        // registerTest(driver);
        registerTest1(driver);

    }

    public static void registerTest(WebDriver driver) throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.id("tab-register")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("registerName")).click();
        driver.findElement(By.id("registerName")).sendKeys("phong");
        Thread.sleep(2000);
        driver.findElement(By.id("registerUsername")).click();
        driver.findElement(By.id("registerUsername")).sendKeys("phong");
        Thread.sleep(2000);
        driver.findElement(By.id("registerEmail")).click();
        driver.findElement(By.id("registerEmail")).sendKeys("elevenine00@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("registerPassword")).click();
        driver.findElement(By.id("registerPassword")).sendKeys("21112003");
        Thread.sleep(2000);
        driver.findElement(By.id("registerRepeatPassword")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".btn:nth-child(10)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.id("registerRepeatPassword")).sendKeys("21112003");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@value='Sign Up']")).click();
        // another way of doing
        // driver.findElement(By.xpath("//input[@value='Sign In' and
        // @type='submit']")).click();
        Thread.sleep(6000);
        driver.close();

        String expected_title = "Trang chủ";
        String actual_title = driver.getTitle();

        if (expected_title.equalsIgnoreCase(actual_title)) {
            System.out.println("Register Successful");
        } else {
            System.out.println("Failed to register");
        }
    }

    public static void registerTest1(WebDriver driver) throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.id("tab-register")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("registerName")).click();
        driver.findElement(By.id("registerName")).sendKeys("minh");
        Thread.sleep(2000);
        driver.findElement(By.id("registerUsername")).click();
        driver.findElement(By.id("registerUsername")).sendKeys("eleveni00");
        Thread.sleep(2000);
        driver.findElement(By.id("registerEmail")).click();
        driver.findElement(By.id("registerEmail")).sendKeys("elevenine00@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("registerPassword")).click();
        driver.findElement(By.id("registerPassword")).sendKeys("1234");
        Thread.sleep(2000);
        driver.findElement(By.id("registerRepeatPassword")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".btn:nth-child(10)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.id("registerRepeatPassword")).sendKeys("1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@value='Sign Up']")).click();
        // another way of doing
        // driver.findElement(By.xpath("//input[@value='Sign In' and
        // @type='submit']")).click();
        Thread.sleep(6000);
        driver.close();

        String expected_title = "Trang chủ";
        String actual_title = driver.getTitle();

        if (expected_title.equalsIgnoreCase(actual_title)) {
            System.out.println("Register Successful");
        } else {
            System.out.println("Failed to register");
        }
    }

}
