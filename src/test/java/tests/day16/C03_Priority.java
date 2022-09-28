package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {

    // Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek
    // priority methodunu kullanırız

    // priority kullanmazsak default olarak 0'dır.


    @Test(priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");

    }

    @Test // Burayı 0 kabul eder bu yüzden ilk bu method çalışır
    public void bestBuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = 2)
    public void amazontest() {
        driver.get("https://www.amazon.com");
    }

    @Test(priority = -1)
    public void hepsiburadatest() {
        driver.get("https://www.hepsiburada.com");
    }

}