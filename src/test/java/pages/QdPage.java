package pages;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.bouncycastle.asn1.iana.IANAObjectIdentifiers.mail;
import static org.bouncycastle.cms.RecipientId.password;

public class QdPage {

    public QdPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement cookies;

    @FindBy(linkText = "Log in")

    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")

    public WebElement emailKutusu;

    @FindBy(id="login-password")

    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")

    public WebElement loginButonu;

    @FindBy(xpath = "//a[text()='Instructor']")

    public WebElement basariliGirisElementi;



    public void providerMethod(String mail,String password){

        if (cookies.isDisplayed()){
            cookies.click();
            ilkLoginLinki.click();
            emailKutusu.sendKeys(mail);
            passwordKutusu.sendKeys(password);
            loginButonu.click();
            ReusableMethods.bekle(2);
        } else {
            ilkLoginLinki.click();
            emailKutusu.sendKeys(mail);
            passwordKutusu.sendKeys(password);
            ReusableMethods.bekle(2);
            loginButonu.click();

        }


    }

    public void loginMethod(){
        cookies.click();
        ilkLoginLinki.click();
        emailKutusu.sendKeys("anevzatcelik@gmail.com");
        passwordKutusu.sendKeys("Nevzat152032");
        loginButonu.click();
    }
    // url>>login>>homepage==sag kose kullanici logo
    @FindBy(xpath = "(//img[@class='img-fluid'])[1]")
    public WebElement kullaniciLogo;

    //url>>login>>homepage>>instructor==message butonu sol kose
    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[5]")
    public WebElement userProfile;

    @FindBy(xpath = "//input[@id='FristName']")
    public WebElement profileFirstNameBox;

    @FindBy(name = "last_name")
    public WebElement profileLastNameBox;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement biographyBox;

    @FindBy(xpath = "//iframe[@id='Biography_ifr']")
    public WebElement iframe;

    @FindBy(xpath = "//*[.='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[text()='Top Categories']")
    public WebElement topCategories;


       /*
              if (qualityPage.cookies.isDisplayed()){
        qualityPage.cookies.click();
        qualityPage.loginLink.click();
        qualityPage.emailBox.sendKeys(mail);
        qualityPage.passwordBox.sendKeys(password);
        qualityPage.loginButton.click();
        ReusableMethods.bekle(2);
    } else {
        qualityPage.loginLink.click();
        qualityPage.emailBox.sendKeys(mail);
        qualityPage.passwordBox.sendKeys(password);
        ReusableMethods.bekle(2);
        qualityPage.loginButton.click();
    }
        */
}