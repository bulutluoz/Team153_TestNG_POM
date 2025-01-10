package tests.day16_PageClassKullanimi;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_WebUniversityTest {

    @Test
    public void test01(){
        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                                webUniversityPage.loginPortalButonu);

        //3."Login Portal" a tiklayin
        webUniversityPage.loginPortalButonu.click();

        //4.Diger window'a gecin
        String hedefUrl = "https://webdriveruniversity.com/Login-Portal/index.html";
        ReusableMethods.urlIleWindowGecisi(hedefUrl);

        //5."username" ve  "password" kutularina deger yazdirin
        Faker faker = new Faker();
        webUniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webUniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        webUniversityPage.loginButonu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopupMenuYazi = "validation failed";
        String actualPopupMenuYazi = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualPopupMenuYazi,expectedPopupMenuYazi);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver()
                .switchTo()
                .alert()
                .accept();

        //9.Ilk sayfaya geri donun
        ReusableMethods.titleIleWindowGecisi("WebDriverUniversity.com");

        //10.Ilk sayfaya donuldugunu test edin

        Assert.assertTrue(webUniversityPage.loginPortalButonu.isDisplayed());


        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
