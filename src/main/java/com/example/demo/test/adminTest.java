package com.example.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.Dimension;

public class adminTest {
    public static void main(String[] args) throws Exception {
        // System.setProperty("webdriver.edge.driver",
        // "/Users/trinhdotuanminh/Downloads/msedgedriver.exe");
        WebDriver driver = new SafariDriver();

        // url web testing

        // addProduct(driver);
        addProductErrName(driver);
        // addProductErrPrice(driver);
        // addProductErrQuantity(driver);
        // UpdateProduct(driver);
        // Category(driver);

    }

    public static void addProduct(WebDriver driver) throws Exception {
        // Test name: add product admin
        // Step # | name | target | value
        // 1 | open | http://localhost:8055/demo/ |
        driver.get("http://localhost:8055/demo/");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        // 3 | click | id=login-btn |
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(1500);
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys("admin");
        Thread.sleep(1500);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys("21112003");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value=\'login now\']")).click();
        // 9 | click | linkText=Admin |
        driver.findElement(By.linkText("Admin")).click();
        Thread.sleep(1500);
        // 10 | click | css=.btn-success > span |
        driver.findElement(By.cssSelector(".btn-success > span")).click();
        Thread.sleep(1500);
        // 11 | click | name=name |
        driver.findElement(By.name("name")).click();
        Thread.sleep(1500);
        // 12 | type | name=name | Thit bo
        driver.findElement(By.name("name")).sendKeys("Thit bo");
        Thread.sleep(1500);
        // 13 | click | name=price |
        driver.findElement(By.name("price")).click();
        Thread.sleep(1500);
        // 14 | type | name=price | 30
        driver.findElement(By.name("price")).sendKeys("30");
        Thread.sleep(1500);
        // 15 | click | name=image |
        driver.findElement(By.name("image")).click();
        Thread.sleep(1500);
        // 16 | type | name=image | image/product-7.png
        driver.findElement(By.name("image")).sendKeys("image/product-7.png");
        Thread.sleep(1500);
        // 17 | click | name=category |
        driver.findElement(By.name("category")).click();
        // 18 | select | name=category | label=Thịt tươi sống
        {
            WebElement dropdown = driver.findElement(By.name("category"));
            dropdown.findElement(By.xpath("//option[. = 'Thịt tươi sống']")).click();
        }
        // 19 | click | name=quantity |
        driver.findElement(By.name("quantity")).click();
        Thread.sleep(1500);
        // 20 | type | name=quantity | 40
        driver.findElement(By.name("quantity")).sendKeys("40");
        Thread.sleep(1500);
        // 21 | click | name=description |
        driver.findElement(By.name("description")).click();
        Thread.sleep(1500);
        // 22 | type | name=description | Thit bo tuoi ngon
        driver.findElement(By.name("description")).sendKeys("Thit bo tuoi ngon");
        Thread.sleep(1500);
        // 23 | click | css=.btn-success:nth-child(2) |
        driver.findElement(By.cssSelector(".btn-success:nth-child(2)")).click();
    }

    public static void addProductErrName(WebDriver driver) throws Exception {
        driver.get("http://localhost:8055/demo/admin");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        // 10 | click | css=.btn-success > span |
        driver.findElement(By.cssSelector(".btn-success > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("price")).click();
        driver.findElement(By.name("price")).sendKeys("34");
        Thread.sleep(1000);
        driver.findElement(By.name("image")).click();
        driver.findElement(By.name("image")).sendKeys("fff");
        Thread.sleep(1000);
        driver.findElement(By.name("quantity")).click();
        driver.findElement(By.name("quantity")).sendKeys("34");
        Thread.sleep(1000);
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).sendKeys("ddd");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn-success:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    public static void addProductErrPrice(WebDriver driver) throws Exception {
        driver.get("http://localhost:8055/demo/admin");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        driver.findElement(By.cssSelector(".btn-success > span")).click();
        Thread.sleep(1500);
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("naem");
        Thread.sleep(1500);
        driver.findElement(By.name("image")).click();
        driver.findElement(By.name("image")).sendKeys("ffff");
        Thread.sleep(1500);
        driver.findElement(By.name("quantity")).click();
        driver.findElement(By.name("quantity")).sendKeys("21");
        Thread.sleep(1500);
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).sendKeys("dddd");
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".btn-success:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    public static void addProductErrQuantity(WebDriver driver) throws Exception {
        driver.get("http://localhost:8055/demo/admin");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        driver.findElement(By.cssSelector(".btn-success > span")).click();
        Thread.sleep(1500);
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("name");
        Thread.sleep(1500);
        driver.findElement(By.name("price")).click();
        driver.findElement(By.name("price")).sendKeys("34");
        Thread.sleep(1500);
        driver.findElement(By.name("image")).click();
        driver.findElement(By.name("image")).sendKeys("ffff");
        Thread.sleep(1500);
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).sendKeys("dddd");
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".btn-success:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    public static void UpdateProduct(WebDriver driver) throws Exception {
        driver.get("http://localhost:8055/demo/admin");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("tr:nth-child(1) a:nth-child(2) > img")).click();
        Thread.sleep(1500);
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(" Cam vàng úc");
        Thread.sleep(1500);
        driver.findElement(By.name("price")).click();
        driver.findElement(By.name("price")).sendKeys("45");
        Thread.sleep(1500);
        driver.findElement(By.name("image")).click();
        driver.findElement(By.cssSelector(".btn-save")).click();
        Thread.sleep(3000);
    }

    public static void DeleteProduct(WebDriver driver) throws Exception {
        driver.get("http://localhost:8055/demo/admin");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("tr:nth-child(1) a:nth-child(4) > img")).click();
        Thread.sleep(3000);
    }

    public static void Category(WebDriver driver) throws Exception {
        driver.get("http://localhost:8055/demo/admin");
        driver.manage().window().setSize(new Dimension(1200, 1087));
        driver.findElement(By.linkText("Categories")).click();
        Thread.sleep(1100);
        driver.findElement(By.cssSelector(".btn-success > span")).click();
        Thread.sleep(1100);
        {
            WebElement element = driver.findElement(By.cssSelector(".btn-success > span"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.name("cname")).click();
        driver.findElement(By.name("cname")).sendKeys("Đồ uống");
        Thread.sleep(1100);
        driver.findElement(By.name("cimage")).click();
        driver.findElement(By.name("cimage")).sendKeys("không có");
        Thread.sleep(1100);
        driver.findElement(By.name("cdescription")).click();
        driver.findElement(By.name("cdescription")).sendKeys("Đồ uống giải khát");
        Thread.sleep(1100);
        driver.findElement(By.cssSelector(".btn-success:nth-child(2)")).click();
        Thread.sleep(1100);
        driver.findElement(By.cssSelector("tr:nth-child(5) a:nth-child(2) > img")).click();
        Thread.sleep(1100);
        driver.findElement(By.name("cimage")).click();
        driver.findElement(By.name("cimage")).sendKeys(" ảnh");
        driver.findElement(By.cssSelector(".btn-save")).click();
        Thread.sleep(1100);
        driver.findElement(By.cssSelector("tr:nth-child(5) a:nth-child(4) > img")).click();
        Thread.sleep(3000);
    }
}
