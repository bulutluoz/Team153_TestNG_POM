package tests.day16_PageClassKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C03_PozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys("wise@gmail.com");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys("12345");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // 7- logout olun
        testotomasyonuPage.logoutButonu
                            .click();

        // 8- sayfayi kapatin
        Driver.quitDriver();
    }
}
