package tests.egzersize;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class qualityTest {

    QdPage qdPage=new QdPage();

    // Kullanici https://qualitydemy.com/ sayfasina gider
    // Siteye basarili bir sekilde giris yapar
    // sag taraf bulunan kullanici menusunden User Profile kismina gider
    // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
    // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular


    @Test
    public void qualityProfilTest(){
        // Kullanici https://qualitydemy.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // Siteye basarili bir sekilde giris yapar
        qdPage.loginMethod();
        // sag taraf bulunan kullanici menusunden User Profile kismina gider
        ReusableMethods.bekle(6);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(qdPage.kullaniciLogo).click(qdPage.userProfile).build().perform();
        // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
        System.out.println(qdPage.profileFirstNameBox.getAttribute("value"));
        String firstname=qdPage.profileFirstNameBox.getAttribute("value");

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(firstname.contains("Furkan"));

        String lastname=qdPage.profileLastNameBox.getAttribute("value");
        softAssert.assertTrue(lastname.contains("Inal"),"lastname duzgun calismiyor");

        Driver.getDriver().switchTo().frame(qdPage.iframe);
        String biagraphy=qdPage.biographyBox.getText();
        softAssert.assertTrue(biagraphy.contains("VELI"));
        System.out.println(biagraphy);
        Driver.getDriver().switchTo().defaultContent();

        // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular
        qdPage.profileFirstNameBox.clear();
        qdPage.profileFirstNameBox.sendKeys("nevzat");
        qdPage.profileLastNameBox.clear();
        qdPage.profileLastNameBox.sendKeys("celik");

        Driver.getDriver().switchTo().frame(qdPage.iframe);
        qdPage.biographyBox.clear();
        qdPage.biographyBox.sendKeys("wisequarter");
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        qdPage.saveBtn.click();

        softAssert.assertAll();

    }
}