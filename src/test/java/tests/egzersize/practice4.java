package tests.egzersize;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;
import pages.OtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class practice4 {
      OtomasyonPage otomasyonPage=new OtomasyonPage();

      @Test
      public void test() {

            //1) Open the browser
            //2) Enter the URL “http://practice.automationtesting.in/”
            Driver.getDriver().get(ConfigReader.getProperty("practiceUrl"));
            //3) Click on Shop Menu
            otomasyonPage.shopbox.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().forward();
            //4) Now click on Home menu button
            otomasyonPage.homebutton.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().forward();
            //5) Test whether the Home page has Three Sliders only
            int sliders = Driver.getDriver().findElements(By.className("n2-ss-slide")).size();
            System.out.println(sliders);
            Assert.assertEquals(3,sliders);

      }
}
