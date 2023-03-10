package tests.egzersize;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class dataProvider {
    QdPage qdPage=new QdPage();


    @DataProvider
    public static Object[][] gonderilecekMail(){
        Object[][] gonderilecekMailvePassword={
                {"nevzat","1234"},
                {"nevzat@hotmail.com","123456"},
                {"ahmet@hotmail.com","nevzat151515151515"},
                {"celik@hotmail.com","nevzat151515151515"},
                {"anevzatcelik@gmail.com","Nevzat152032"}};
        return gonderilecekMailvePassword;
    }

    @Test(dataProvider = "gonderilecekMail")
    public void qualityTest(String mail,String password){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.providerMethod(mail,password);

    }

}