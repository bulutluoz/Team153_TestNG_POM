package tests.day16_PageClassKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C01_PageClassKullanimi {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin
        int actualBulunanUrunSayisi = testotomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi > 0 );

        // ilk urunu tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        // acilan sayfada urun isminde case sensitive olmadan phone bulundugunu test edin

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi
                                                    .getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        Driver.quitDriver();
    }
}
