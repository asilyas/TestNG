package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){
        //qd anasayfaya gidip geçerli kullanıcı ve password ile giriş yapın ve başarılı olduğunu test edin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tıklayıcaz

        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();


    }

}
