package tests.day17_testDatalariniDinamikYapma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DinamikNegatifLoginTesti {

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3-  3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        //6-sayfayi kapatin
        Driver.quitDriver();
    }

    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        //3-  3 farkli test method’u olusturun.
        // - gecersiz email, gecerli password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        //6-sayfayi kapatin
        Driver.quitDriver();
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        //3-  3 farkli test method’u olusturun.
        // - gecersiz email, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        //6-sayfayi kapatin
        Driver.quitDriver();
    }


}
