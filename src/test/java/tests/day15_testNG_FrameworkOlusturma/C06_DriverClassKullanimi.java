package tests.day15_testNG_FrameworkOlusturma;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_DriverClassKullanimi {

    @Test(priority = -10)
    public void testotomasyonuTest(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test
    public void wisequarterTest(){
        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test
    public void bestbuyTest(){
        Driver.getDriver().get("https://www.bestbuy.com");

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);


        Driver.quitDriver();
    }
}
