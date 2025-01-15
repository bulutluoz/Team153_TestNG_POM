package tests.day19_paralelCalistirma_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluNegatifLoginTesti extends TestBaseRapor {


    @Test
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz password testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici https://www.testotomasyonu.com/ anasayfasina gider");

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Email kutusuna gecerli email degerini girer");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password degerini girer");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6-sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizEmailTesti(){
        extentTest = extentReports.createTest("Gecersiz email testi",
                "Kullanici gecersiz email ve gecerli password ile giris yapamamali");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici https://www.testotomasyonu.com/ anasayfasina gider");

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        // - gecersiz email, gecerli password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Email kutusuna gecersiz email degerini girer");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna gecerli password degerini girer");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6-sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz email ve gecersiz password testi",
                "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici https://www.testotomasyonu.com/ anasayfasina gider");

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        // - gecersiz email, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Email kutusuna gecersiz email degerini girer");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password degerini girer");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6-sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }




}
