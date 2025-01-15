package tests.day16_PageClassKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02_TestotomasyonuFiyatTesti {

    @Test (groups = "E2E")
    public void fiyatTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // dress icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);

        // cikan urunlerden 3. urunu tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                            .get(2)
                            .click();

        // acilan sayfada urun fiyatinin 59$ oldugunu test edin

        double expectedFiyat = 59;

        String actualFiyatStr = testotomasyonuPage.urunSayfasindakiFiyatElementi
                                                    .getText(); // $59.00

        actualFiyatStr = actualFiyatStr.replaceAll("\\D",""); // 5900

        Double actualFiyat = Double.parseDouble(actualFiyatStr) / 100; // 59.00

        Assert.assertEquals(actualFiyat,expectedFiyat);

        Driver.quitDriver();

    }
}
