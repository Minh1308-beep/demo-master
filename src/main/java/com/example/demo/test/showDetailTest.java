package com.example.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

public class showDetailTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new SafariDriver();

        detailProduct(driver);

    }

    public static void detailProduct(WebDriver driver) throws Exception {

        driver.get("http://localhost:8055/demo/");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sản Phẩm")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#swiper-wrapper-1171f2ca10e3575a > .swiper-slide-active img")).click();
        Thread.sleep(3000);
    }

    public static void findProductErr(WebDriver driver) throws Exception {

        driver.get("http://localhost:8055/demo/");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        driver.findElement(By.id("search-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("search-box")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("search-box")).sendKeys("Cam");
        Thread.sleep(1000);
        driver.findElement(By.id("search-box")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Sản Phẩm")).click();
        Thread.sleep(3000);
    }

}
