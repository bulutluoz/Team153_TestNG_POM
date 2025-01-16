package tests.day20_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegatifLoginTesti extends TestBaseCross {

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- account linkine basin
        WebElement accountLinki = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLinki.click();
        ReusableMethods.bekle(1);

        //3-  3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password girin
        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());


        //6-sayfayi kapatin
        driver.quit();
    }

    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- account linkine basin
        WebElement accountLinki = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLinki.click();
        ReusableMethods.bekle(1);

        //3-  3 farkli test method’u olusturun.
        // - gecersiz email, gecerli password girin
        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());


        //6-sayfayi kapatin
        driver.quit();
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- account linkine basin
        WebElement accountLinki = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLinki.click();
        ReusableMethods.bekle(1);

        //3-  3 farkli test method’u olusturun.
        // - gecersiz email, gecersiz password girin
        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());


        //6-sayfayi kapatin
        driver.quit();
    }
}
