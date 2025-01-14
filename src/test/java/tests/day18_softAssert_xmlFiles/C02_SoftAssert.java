package tests.day18_softAssert_xmlFiles;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssert {

    @Test
    public void zeroAppTesti(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));


        SoftAssert softAssert = new SoftAssert();
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin

        String expectedUrl = ConfigReader.getProperty("zeroUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,
                "ZeroApp anasayfa testi failed");

        // 3. Sign in butonuna basin
        ZeroWebPage zeroWebPage = new ZeroWebPage();
        zeroWebPage.anasayfaSignInButton
                    .click();

        // 4. Login kutusuna “username” yazin
        zeroWebPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));

        // 5. Password kutusuna “password” yazin
        zeroWebPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

        // 6. Sign in tusuna basin
        zeroWebPage.signInButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate()
                            .back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebPage.onlineBankingMenuElementi.isDisplayed());

        // 9. Online banking menusunu tiklayin
        zeroWebPage.onlineBankingMenuElementi
                .click();

        //10. Pay Bills sayfasina gidin
        zeroWebPage.payBillsMenuElementi
                .click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebPage.purchaseForeignCurrency
                .click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebPage.currencyDdm.isEnabled(),
                "Currency dropdown menusu erisilebilir degil");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroWebPage.currencyDdm);

        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin

        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption,
                "currency dropdown menuden istenen option secilemedi");


        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,
                "Dropdown menude 16 option bulunmuyor");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        String expectedDropdownIcerik = "Canada (dollar)";
        List<String> ddmOptionListesi = ReusableMethods.stringListeDonustur(select.getOptions());

        softAssert.assertTrue(ddmOptionListesi.contains(expectedDropdownIcerik),
                "Dropdown menude Canada (dollar) bulunmuyor");

        //17. Sayfayi kapatin

        ReusableMethods.bekle(3);

        softAssert.assertAll();
        Driver.quitDriver();

    }
}
