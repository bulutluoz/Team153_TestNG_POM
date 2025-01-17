package tests.day20_dataProvider;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderIlenegatifLoginTesti {


    // Verilen listedeki herbir Email-password ikilisi icin
    // asagidaki testi yapin
    // yigit@kmail.com   125687
    // tugba@tmail.com   345678
    // yusuf@mmail.com   456789
    // sumeyra@smail.com 342321
    // canan@cmail.com 987098

    @DataProvider
    public static Object[][] kullaniciBilgileriProvideri() {

        String[][] kullaniciBilgileriArr = {
                                                {"yigit@kmail.com","125687"},
                                                {"tugba@tmail.com","345678"},
                                                {"yusuf@mmail.com","456789"},
                                                {"wise@gmail.com","12345"},
                                                {"sumeyra@smail.com","342321"},
                                                {"canan@cmail.com","987098"}
                                            };


        return kullaniciBilgileriArr;
    }

    @Test(dataProvider = "kullaniciBilgileriProvideri")
    public void negatifLoginTesti(String email , String password){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- email ve password olarak listede verilen degerleri yazin
        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(email);
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(password);

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin

        try {
            Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        } catch (NoSuchElementException e) {
            // eger NoSuchElementException aliyorsak
            // kullanici bilgilerini yazdigimizda sisteme "istenmedigi halde"
            // giris yapmisiz demektir.
            // giris yapildiginda sistemden logout olunmasi gerekir
            testotomasyonuPage.logoutButonu.click();
            // ama try-catch ile FAILED olan bir assertion'i normal hale dondurduk
            // o exception'i yeniden olusturmaliyiz
            throw new NoSuchElementException("Verilen "+email+" ile sisteme giris yapildi");

        }

        //6-sayfayi kapatin
        Driver.quitDriver();
    }

}
