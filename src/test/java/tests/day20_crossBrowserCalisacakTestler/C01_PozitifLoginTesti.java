package tests.day20_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_PozitifLoginTesti extends TestBaseCross {

    @Test
    public void dinamikPozitifLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin

        // Driver.getDriver().get("configuration.properties dosyasina git bana toUrl degerini getir");
        driver.get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        WebElement accountLinki = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLinki.click();

        // 3- Kullanici email'i olarak gecerli email girin
        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Login butonuna basarak login olun
        driver.findElement(By.id("submitlogin"))
                .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assert.assertTrue(logoutButonu.isDisplayed());

        // 7- logout olun
        logoutButonu
                .click();

        // 8- sayfayi kapatin
        driver.quit();

    }


}
