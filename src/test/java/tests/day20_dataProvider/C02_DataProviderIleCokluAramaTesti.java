package tests.day20_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderIleCokluAramaTesti {


    // testotomasyonu anasayfaya gidip
    // bir liste olarak verilen urunleri
    // tek tek aratin ve her urunun sayfada bulunabildigini test edin
    // phone, dress, java, samsung, nutella, apple, cokoprens



    /*
        Data provider,
        test method'unun disindan bize test edilecek data'lari tek tek yollayan ozel bir method'dur

        boylece kac farkli data varsa
        her biri icin Test Method'u tekrar tekrar calistirilir
        ve panel'de tek bir method calistirma yerine
        kac kez tekrar edildiyse o kadar test calistirildigi raporlanir

        Data provider kullanmak icin
        1- test method'unu disardan parametre gelecek sekilde olusturun
        2- test method'una disardan data'lari yollayacak
           dataProvider'i olusturun
           Bunun icin test method'unun yanina () icerisinde
           dataProvider yazip, intelliJ'den method'u olusturmasini isteyebiliriz
        3- @DataProvider notasyonuna sahip olan method'un
           MUTLAKA 2 katli Object array dondurmesi gerekir
     */

    @DataProvider
    public static Object[][] urunIsimDataProvideri() {

        String[][] aranacakUrunlerArrayi =
                {{"phone"}, {"dress"}, {"java"}, {"samsung"}, {"nutella"}, {"apple"}, {"cokoprens"}};

        return aranacakUrunlerArrayi;
    }

    @Test (dataProvider = "urunIsimDataProvideri")
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
