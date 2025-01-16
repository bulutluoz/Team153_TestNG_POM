package tests.day20_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_RaporluDataProviderTesti {

    // testotomasyonu anasayfaya gidip
    // bir liste olarak verilen urunleri
    // tek tek aratin ve her urunun sayfada bulunabildigini test edin
    // phone, dress, java, samsung, nutella, apple, cokoprens

    @DataProvider
    public static Object[][] urunIsimDataProvideri() {

        String[][] aranacakUrunlerArrayi =
                {{"phone"}, {"dress"}, {"java"}, {"samsung"}, {"nutella"}, {"apple"}, {"cokoprens"}};

        return aranacakUrunlerArrayi;
    }

    @Test(dataProvider = "urunIsimDataProvideri")
    public void cokluAramaTesti(String aranacakUrun){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

        String unExpectedAramaSonucu = ConfigReader.getProperty("toBulunamadiYazisi");
        String actualAramaSonucu = testotomasyonuPage.aramaSonucYaziElementi.getText();

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu,
                aranacakUrun + " arandiginda sonuc bulunamadi");

    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
