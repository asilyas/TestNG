package tests.day10_TestNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_FacebookLogin {

   @Test
    public void facebookTesti(){

       // 1 - https://www.facebook.com/ adresine gidin
       Driver.getDriver().get("https://facebook.com");
       // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
       // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

       FacebookPage facebookPage=new FacebookPage();
       Faker faker = new Faker();

       facebookPage.emailKutusu.sendKeys(("abc"+faker.internet().emailAddress()));
       facebookPage.passwordKutusu.sendKeys(faker.internet().password());

       facebookPage.loginButonu.click();

       // 4- Basarili giris yapilamadigini test edin

       Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

       ReusableMethods.bekle(3);

       Driver.closeDriver();



   }


}
