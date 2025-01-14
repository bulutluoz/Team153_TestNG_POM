package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebPage {

    public ZeroWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(className = "icon-signin")
    public WebElement anasayfaSignInButton;

    @FindBy (id = "user_login")
    public WebElement loginKutusu;

    @FindBy(id = "user_password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@name='submit']")
    public WebElement signInButonu;

    @FindBy(xpath = "//strong[.='Online Banking']")
    public WebElement onlineBankingMenuElementi;

    @FindBy(xpath = "//*[@id='pay_bills_link']")
    public WebElement payBillsMenuElementi;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(id="pc_currency")
    public WebElement currencyDdm;


}
