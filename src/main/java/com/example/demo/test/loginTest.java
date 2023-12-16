package com.example.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class loginTest {
    public static void main(String[] args) throws Exception {
        // System.setProperty("webdriver.edge.driver",
        // "/Users/trinhdotuanminh/Downloads/msedgedriver.exe");
        WebDriver driver = new SafariDriver();

        // url web testing
        driver.get("http://localhost:8055/demo/login-test");
        driver.manage().window().setSize(new Dimension(1211, 896));

        loginTest(driver);

    }

    public static void loginTest(WebDriver driver) throws Exception {
        // Find user Name and set username
        driver.findElement(By.id("loginName")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginName")).sendKeys("admin");
        Thread.sleep(2000);
        driver.findElement(By.id("loginPassword")).click();
        driver.findElement(By.id("loginPassword")).sendKeys("21112003");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn:nth-child(7)")).click();
        Thread.sleep(6000);

        // another way of doing
        // driver.findElement(By.xpath("//input[@value='Sign In' and
        // @type='submit']")).click();
        driver.close();

        String expected_title = "Trang chủ";
        String actual_title = driver.getTitle();

        if (expected_title.equalsIgnoreCase(actual_title)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Failed to login");
        }
    }

}
