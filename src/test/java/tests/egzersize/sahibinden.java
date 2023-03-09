package tests.egzersize;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SahibindenPage;
import utilities.ConfigReader;
import utilities.Driver;

public class sahibinden {

    @Test
    public void sahibindenTesti(){
        SahibindenPage sahibindenPage=new SahibindenPage();
        // sahibinden.com  a git
        Driver.getDriver().get(ConfigReader.getProperty("sahibindenUrl"));
        // gecerli username ve password ile giriş yapın

        //  sahibindenPage.emailKutusu.sendKeys(ConfigReader.getProperty("sahibindenUser"));
        //  sahibindenPage.ilkLogin.click();
        //  sahibindenPage.passwordKutusu.sendKeys(ConfigReader.getProperty("sahibindenPassword"));
        //  sahibindenPage.ikinciLogin.click();
        //  arama kutusuna click yapıp audi aratın
          sahibindenPage.aramaKutusu.sendKeys(ConfigReader.getProperty("sahibindenAranacakKelime")+ Keys.ENTER);
        // çıkan sonuçların 1000 den fazla olduğunu doğrulayın ve sonuçların Audi içerip içermediğini test edin
          String sonucYazisi= sahibindenPage.aramaSonucSayisi.getText().replace(".","");
          int sonucSayisi=Integer.parseInt(sonucYazisi);
          SoftAssert softAssert=new SoftAssert();

          softAssert.assertTrue(sonucSayisi>1000,"arama sonuçları 1000 den küçük");

          String expectedSonucYazisi=ConfigReader.getProperty("sahibindenAranacakKelime");
          String actualsonucYazisi=sahibindenPage.aramaSonucYazisi.getText();

          softAssert.assertTrue(actualsonucYazisi.contains(expectedSonucYazisi));

          softAssert.assertAll();

          Driver.closeDriver();


    }


}
