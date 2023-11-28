package com.example.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class loginSuccessful {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.edge.driver", "/Users/trinhdotuanminh/Downloads/msedgedriver.exe");
        WebDriver driver = new SafariDriver();

        //url web testing
        driver.get("http://localhost:8055/demo/login");
        driver.manage().window().maximize();

        //Find user Name and set username
        WebElement txtbx_username = driver.findElement(By.id("inputEmail"));
        txtbx_username.sendKeys("admin");
        Thread.sleep(2000);
        //Find password and set password
        driver.findElement(By.id("inputPassword")).sendKeys("1234");
        Thread.sleep(2000);

        driver.findElement(By.className("sign-btn")).click();
        Thread.sleep(6000);
        
        //another way of doing
        //driver.findElement(By.xpath("//input[@value='Sign In' and @type='submit']")).click();
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
