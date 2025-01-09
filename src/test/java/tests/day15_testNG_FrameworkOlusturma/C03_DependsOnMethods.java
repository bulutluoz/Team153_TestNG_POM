package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        // url'in testotomasyonu icerdigini test edin

    }

    @Test
    public void phoneAramaTesti(){
        // 2- phone icin arama yapip,

        // urun bulunabildigini test edin

    }

    @Test
    public void urunIsimTesti(){
        // 3- ilk urunu tiklayip,


        // urun isminde case sensitive olmadan phone bulundugunu test edin

    }

}
