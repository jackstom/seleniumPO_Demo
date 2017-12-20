package com.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class test1 {
    public WebDriver driver;

    public void InitDriver(){
        String driverPath=System.getProperty("user.dir")+"/chromedriver.exe";
        System.out.println(driverPath);
        System.setProperty("webdriver.Chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get("http://www.costco.ca");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    public void loginScript(){


        try{
            String costcoTitle = "Welcome to Costco Wholesale";
            assert costcoTitle == driver.getTitle();
            System.out.println("test  pass");
        }catch(Exception e){
            e.printStackTrace();
        }
        //click the radio option QC
        driver.findElement(By.xpath(".//*[@id='region-radio-buttons']/div[2]/label[4]")).click();
        driver.findElement(By.id("language-region-set")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).sendKeys("coohoh@hotmail.com");
        driver.findElement(By.id("logonPassword")).sendKeys("gugu1214");
        driver.findElement(By.xpath(".//*[@id='LogonForm']/fieldset/div[5]/input")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement myCount = driver.findElement(By.id("myaccount-d"));

        Actions action = new Actions(driver);
        action.moveToElement(myCount).perform();
        driver.findElement(By.xpath(".//*[@id='header_renewMembership']/li[1]/a")).click();




        //  driver.quit();


    }
    public static void main(String[] args) {

        test1 tc = new test1();
        tc.InitDriver();
        tc.loginScript();

    }

}
