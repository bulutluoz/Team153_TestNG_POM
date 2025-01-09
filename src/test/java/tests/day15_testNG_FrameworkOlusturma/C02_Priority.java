package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Priority {

    // 3 test method'u olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu sayfasina gidip url'in testotomasyonu icerdigini test edin
    // 2- wisequarter sayfasina gidip url'in wisequarter icerdigini test edin
    // 3- bestbuy sayfasina gidip url'in bestbuy icerdigini test edin

    /*
        1- TestNG test method'larini alfabetik siraya gore calistirir
        2- Eger siralamayi belirlemek istersek
           method'lara priority degeri verebiliriz
           bu durumda priority degeri kucuk olandan baslayip, buyuge dogru sirayla calistirir
        3- bazi method'lara priority tanimlayip bazilarina tanimlamazsak
           priority atanmayanlarin priority degeri 0 olur
           ve siralama bu degere gore yapilir
        4- priority degeri esit olanlar varsa
           onlar kendi iclerinde harf sirasina gore calisirlar
           digerleri ise priority degerine gore calisir
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test (priority = -10)
    public void testotomasyonuTest(){

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
    }

    @Test
    public void wisequarterTest(){
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
    }

    @Test
    public void bestbuyTest(){
        driver.get("https://www.bestbuy.com");

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
    }
}
