package tests.day20_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C03_AlisverisTesti extends TestBaseCross {

    @Test
    public void alisverisTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- belirlenmis arama kelimesi icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu
                .sendKeys( ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        ReusableMethods.bekle(1);

        //3- Listelenen sonuclardan ilkini tiklayin
        driver.findElements(By.className("prod-img"))
                .get(0)
                .click();
        ReusableMethods.bekle(1);

        //4- urun ismini kaydedin
        String ilkUrunIsmi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"))
                                    .getText();

        // ve urunu sepete ekleyin
        driver.findElement(By.className("add-to-cart"))
                .click();
        ReusableMethods.bekle(2);

        //5- your cart linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='e-cart'])[2]"))
                .click();
        ReusableMethods.bekle(1);

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepettekiUrunIsmi = driver.findElement(By.xpath("//*[@class='product-title text-center']"))
                                            .getText();

        Assert.assertEquals(ilkUrunIsmi , sepettekiUrunIsmi);

        //7- sayfayi kapatin
        driver.quit();
    }

}
