package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestotomasyonuPage {

   public TestotomasyonuPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }


    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucYaziElementi;

    @FindBy(className = "prod-img")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//*[@class=' heading-sm mb-4']")
    public WebElement urunSayfasindakiIsimElementi;

    @FindBy(id = "priceproduct")
    public WebElement urunSayfasindakiFiyatElementi;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(id = "email")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(id="password")
    public WebElement loginSayfasiPasswordKutusu;

    @FindBy(id="submitlogin")
    public WebElement loginSayfasiSubmitButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButonu;

   @FindBy (className = "add-to-cart")
   public WebElement urunSayfasindakiSepeteEkleButonu;

   @FindBy (xpath = "(//*[@class='e-cart'])[2]")
   public WebElement urunSayfasindakiYourCartButonu;

   @FindBy (xpath = "//*[@class='product-title text-center']")
   public WebElement yourCartSayfasindakiUrunIsmi;


}
