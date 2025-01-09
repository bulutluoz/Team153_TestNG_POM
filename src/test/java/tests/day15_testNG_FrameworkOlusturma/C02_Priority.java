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


    @Test
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
