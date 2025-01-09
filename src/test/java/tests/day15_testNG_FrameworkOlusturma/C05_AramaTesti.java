package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C05_AramaTesti {

    @Test
    public void test01(){

        //1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //2- phone icin arama yapin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin
        List<WebElement> bulunanUrunElementleriList =
                Driver.getDriver().findElements(By.xpath("//*[@class='product-box my-2  py-1']"));
        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assert.assertTrue(actualSonucSayisi>3);

        //4- ilk urunu tiklayin
        bulunanUrunElementleriList.get(0).click();


        //5- acilan urun sayfasinda,
        //   urun isminde case sensitive olmadan phone bulundugunu test edin.
        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"))
                                        .getText()
                                        .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();
    }
}
