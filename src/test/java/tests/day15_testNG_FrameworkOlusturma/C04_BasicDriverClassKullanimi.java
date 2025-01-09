package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_BasicDriverClassKullanimi {



        /*
            TestNG Page Object Model (POM) kullanir

            POM temel olarak test icin ihtiyac duydugumuz
            locate, driver ve test datalarinin dinamik olmasini
            yani tek bir yerden yonetlebilmesini
            ve Test method'larinin bu dinamik yontemle guncellenebilmesine dayanir

            Ilk olarak driver objesini dinamik yapalim

            POM TestBase Class kullanmak yerine
            Driver class'inda
            bize WebDriver objesi donduren bir getDriver()
            ve webDriver'i kapatan quitDriver()
            kullanmayi tercih etmistir
         */

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // wisequarter anasayfaya gidin
        Driver.getDriver().get("https://www.wisequarter.com");
        ReusableMethods.bekle(1);

        // tekrar testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(2);

        // arama kutusunu locate edip kaydedin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));


        aramaKutusu.sendKeys("phone");

        ReusableMethods.bekle(3);

        Driver.quitDriver();
    }


}
