package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestotomasyonuPage {


    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucYaziElementi;

    @FindBy(className = "prod-img")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//*[@class=' heading-sm mb-4']")
    public WebElement urunSayfasindakiIsimElementi;



}
