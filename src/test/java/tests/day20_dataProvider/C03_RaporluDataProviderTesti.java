package tests.day20_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluDataProviderTesti extends TestBaseRapor {

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
        extentTest = extentReports.createTest(aranacakUrun+" arama testi",
                "Kullanici testotomasyonu sayfasinda " + aranacakUrun + " arattiginda sonuc bulabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        extentTest.info("Arama kutusuna " + aranacakUrun + " yazip aratir");

        String unExpectedAramaSonucu = ConfigReader.getProperty("toBulunamadiYazisi");
        String actualAramaSonucu = testotomasyonuPage.aramaSonucYaziElementi.getText();

        ReusableMethods.bekle(1);

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        extentTest.pass("Arama sonucunda " + aranacakUrun + " bulunabildigini test eder");

    }

}
