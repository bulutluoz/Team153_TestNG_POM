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

    /*
        1-
        b testinde dependsOnMethods ="a" yaziyorsa
        a calisip PASSED olmadikca b'yi calistirma demek olur.
        a calismaz veya calisip FAILED olursa b method'u IGNORE edilir ve calistirilmaz

        2-
        eger sadece b method'unu calistirmak istersek
        b method'u "benim calismam a'nin calisip PASSED olmasina bagli" der
        ve once a'yi calistirir
        a calisip PASSED olduktan sonra b calisir
        ANCAK bu bag 2 test method'u icin gecerlidir
        3 method birbirine bagli oldugunda, 3.yu calistirmak istedigimizde
        tum method'lar CALISMAZ

        3-
        dependsOnMethods BIR SIRALAMA YONTEMI degildir
        sadece sira bir method'a geldiginde
        bagli oldugu method'un once calismasini saglar



     */

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

    @Test (dependsOnMethods = "anasayfaTesti")
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

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){
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
