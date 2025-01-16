package tests.day20_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_CokluAramaTesti {

    // testotomasyonu anasayfaya gidip
    // bir liste olarak verilen urunleri
    // tek tek aratin ve her urunun sayfada bulunabildigini test edin
    // phone, dress, java, samsung, nutella, apple, cokoprens

    @Test
    public void cokluAramaTesti(){

        List<String> aranacakUrunList = new ArrayList<>(Arrays.asList("phone", "dress", "java", "samsung", "nutella", "apple", "cokoprens"));

        System.out.println(aranacakUrunList);
        // [phone, dress, java, samsung, nutella, apple, cokoprens]

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (String eachUrun : aranacakUrunList){

            testotomasyonuPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);

            softAssert.assertTrue(testotomasyonuPage.bulunanUrunElementleriList.size()>0,
                    eachUrun +" icin sonuc bulunamadi");

        }

        softAssert.assertAll();
        Driver.quitDriver();
    }

}
