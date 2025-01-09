package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods {

    // 3 test method'u olusturup asagidaki gorevleri gerceklestirin
    // 1- testotomasyonu anasayfaya gidip, url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip, urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan phone bulundugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip,
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test
    public void phoneAramaTesti(){
        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);

    }

    @Test
    public void urunIsimTesti(){
        // 3- ilk urunu tiklayip,
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();


        // urun isminde case sensitive olmadan phone bulundugunu test edin
        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"))
                                        .getText()
                                        .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

    }

}
