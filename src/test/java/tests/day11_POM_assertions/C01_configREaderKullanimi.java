package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_configREaderKullanimi {

    @Test
    public void test01(){

        // amazona gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Test datası olarak verilen kelime için arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        String expectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucElementi= amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucElementi.contains(expectedIcerik));

        Driver.closeDriver();

    }
}
