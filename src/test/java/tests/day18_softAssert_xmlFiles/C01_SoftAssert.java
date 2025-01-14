package tests.day18_softAssert_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssert {

    /*
        SoftAssert'un tek negatif tarafi
        tum raporlamayi assertAll() kullandigimiz satir icin yapmasidir

        verilen hata raporundan
        kac assertion'in failed oldugunu anlayabiliriz
        ama hangi assertion'larin failed oldugunu anlayamayiz

        Bu negatif durumu gidermek icin
        softAsset kullandigimizda
        hatanin hangi assertion'dan kaynaklandigini anlayabilecegimiz
        bir mesaj ekleyebiliriz
     */

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Url'in testotomasyonu icerdigini dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),
                "url istenen icerigi barindirmiyor,satir39");


        // belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini dogrulayin
        int actualBulunanUrunSayisi = testotomasyonuPage.bulunanUrunElementleriList
                .size();

        softAssert.assertTrue(actualBulunanUrunSayisi > 0,
                "aranan urun sayfada bulunamadi, satir52" );

        // ilk urunu tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();

        // acilan sayfada urun isminde case sensitive olmadan
        // belirlenmis aranacakKelime'nin bulundugunu dogrulayin

        String expectedUrunIsimIcerigi = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi),
                "urun ismi belirlenen kelimeyi icermiyor,satir 68");

        softAssert.assertAll();

        Driver.quitDriver();
    }

}
