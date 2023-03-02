package tests.day12_xlmFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti(){
        extentTest=extentReports.createTest("Pozitif login testi","geçerli bilgilerle giris yapılabilmeli");
        //qd anasayfaya gidip geçerli kullanıcı ve password ile giriş yapın ve başarılı olduğunu test edin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Qualitydemy anasayfaya gidildi");

        // login linkine tıklayıcaz

        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();
        extentTest.info("ilk login linkine tıklandı");

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("gecerli email yazıldı");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("gecerli password girildi");
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        extentTest.pass("başarılı şekilde test edildiği görüldü");



    }

}
