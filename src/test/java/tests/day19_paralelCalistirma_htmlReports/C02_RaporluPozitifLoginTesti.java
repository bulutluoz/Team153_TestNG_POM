package tests.day19_paralelCalistirma_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void reaporluPozitifLoginTesti(){
        extentTest = extentReports.createTest("Pozitif Login Testi",
                "gecerli Email ve sifre ile sisteme giris yapilabilmeli");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        // Driver.getDriver().get("configuration.properties dosyasina git bana toUrl degerini getir");
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici https://www.testotomasyonu.com/ anasayfasina gider");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("account linkine basar");

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olur");

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        // 7- logout olun
        testotomasyonuPage.logoutButonu
                .click();
        extentTest.info("logout olur");

        // 8- sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }



}
