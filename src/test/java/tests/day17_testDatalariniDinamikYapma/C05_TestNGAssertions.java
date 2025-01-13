package tests.day17_testDatalariniDinamikYapma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_TestNGAssertions {

    /*
        Bazi test method'larinda 1'den fazla assertion olabilir

        Eger var olan assertion'lardan birden fazlasi failed oluyorsa
        Ilk FAILED olan assertion'da
        kodun calismasi durur ve geriye kalan assertion'lar calismamis olur

        Bulunan ilk hatayi duzeltmemiz
        geriye kalan assertion'larin PASSED olacagini garanti etmez

        failed olan her bir assertion icin yeniden testin calistirilip
        duzeldiginden emin olmamiz gerekir
        Bu da ozellikle toplu calistirmalarda
        tekrar tekrar tum testlerin calistirilmasi sebebiyle
        ciddi zaman kayiplarina neden olabilir.

     */

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));


        // belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin
        int actualBulunanUrunSayisi = testotomasyonuPage.bulunanUrunElementleriList
                                                        .size();

        Assert.assertTrue(actualBulunanUrunSayisi > 0 );

        // ilk urunu tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        // acilan sayfada urun isminde case sensitive olmadan
        // belirlenmis aranacakKelime'nin bulundugunu test edin

        String expectedUrunIsimIcerigi = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi
                                                    .getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        Driver.quitDriver();
    }
}
