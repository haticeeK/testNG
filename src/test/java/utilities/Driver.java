package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;
    /*
    Testlerimizi çalıştırdığımızda her seferinde
    yeni driver oluşturduğu için her test methodu için yeni bir pencere(driver)
    açıyor.Eğer driver'a bir değer atanmamışsa yani driver==null ise bir kere driver'ı
    çalıştır diyerek bir kere if içini çalıştıracak. Ve driver artık bir kere çalıştığı
    için ve değer atandığı için null olmayacak ve direkt return edecek ve diğer testlerimiz
    aynı pencere (driver) üzerinde çalışacak
     */

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) { //driver'a değer atanmışsa
            driver.close();
            driver = null; //Kapandıktan sonra sonraki açmaları garanti altına almak için driver'ı tekrar null yaptık

        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}