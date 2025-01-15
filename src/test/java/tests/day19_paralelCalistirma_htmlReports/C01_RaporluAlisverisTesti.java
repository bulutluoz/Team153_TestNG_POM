package tests.day19_paralelCalistirma_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAlisverisTesti extends TestBaseRapor {
    /*
        Bir test method'unun raporlu olmasini istiyorsaniz
        1- extends TestBaseRapor ile class'i TestBaseRapor'a child yapariz
        2- Page Object Model'e uygun olarak test adimlari icin
           gerekli kodlari yazariz
        3- HER TEST METHOD'u icin extentTest objesi olusturup
           o test method'una raporda gorunecek bir isim
           ve bir aciklama yaziyoruz
        4- Raporda gorunmesini istedigimiz her adimi
           extentTest objesi yardimiyla olusturun

     */

    @Test
    public void alisverisTesti(){
        extentTest = extentReports.createTest("Alisveris Testi",
                "Kullanici istedigi urunun sepete eklendigini test edebilmeli");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici https://www.testotomasyonu.com/ anasayfasina gider");

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu
                .sendKeys( ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenmis arama kelimesi icin arama yapar");

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();
        extentTest.info("Listelenen sonuclardan ilkini tiklar");

        //4- urun ismini kaydedin
        String ilkUrunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi.getText();
        extentTest.info("Tikladigi urunun ismini kaydeder");

        // ve urunu sepete ekleyin
        testotomasyonuPage.urunSayfasindakiSepeteEkleButonu
                .click();
        extentTest.info("urunu sepete ekler");

        //5- your cart linkine tiklayin
        testotomasyonuPage.urunSayfasindakiYourCartButonu
                .click();
        extentTest.info("your cart linkine tiklar");

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepettekiUrunIsmi = testotomasyonuPage.yourCartSayfasindakiUrunIsmi.getText();

        Assert.assertEquals(ilkUrunIsmi , sepettekiUrunIsmi);
        extentTest.pass("kaydettigi urun ismi ile sepetteki urun isminin ayni oldugunu test eder");

        //7- sayfayi kapatin

        extentTest.info("sayfayi kapatir");
    }

}
