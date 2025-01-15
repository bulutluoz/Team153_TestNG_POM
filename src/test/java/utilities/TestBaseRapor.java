package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseRapor {

    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar
    protected static ExtentSparkReporter extentSparkReporter; // Html raporu duzenler
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz

    // Test işlemine başlamadan hemen önce (test methodundan önce değil, tüm test işleminden önce)
    // calisir ve rapor icin gerekli atamalari ve ayarlari yapar
    @BeforeTest(alwaysRun = true) // alwaysRun : her zaman çalıştır.
    public void setUpTest() {
        extentReports = new ExtentReports(); // Raporlamayi baslatir
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        String date = new SimpleDateFormat("_yyMMdd_hhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor"+date+".html";
        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz,
        // filePath ile dosya yolunu belirliyoruz.
        // date class'i ile raporumuza tarih etiketi ekliyoruz
        extentSparkReporter = new ExtentSparkReporter(filePath);
        extentReports.attachReporter(extentSparkReporter);

        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Enviroment","live");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Yusuf ONAL");
        extentSparkReporter.config().setDocumentTitle("TestNG Test Raporlari");
        extentSparkReporter.config().setReportName("Html Reports");
    }


    // Her test methodundan sonra eğer assertion failed olursa, ekran görüntüsü alıp rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String resimYolu = ReusableMethods.raporaResimEkle(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(resimYolu);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.quitDriver();

    }


    // Raporlandırmayı sonlandırmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}