package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SahibindenPage {

    public SahibindenPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='loginSelectionPageEmail']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//button[@id=\"signInWithEmail\"]")
    public WebElement ilkLogin;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id= "userLoginSubmitButton")
    public WebElement ikinciLogin;

    @FindBy(id= "secure-login")
    public WebElement girisTusu;

    @FindBy(id= "searchText")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//span[@class=\"js-format-number\"])[1]")
    public WebElement aramaSonucSayisi;

    @FindBy(xpath = "//h1")
    public WebElement aramaSonucYazisi;


}
