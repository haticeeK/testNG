package tests.day17;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeClassAfterClass;
public class C03_SoftAssert extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() {
        /*
        SoftAssert başlangıç ve bitiş satırları arasındaki tüm assertion'ları yapıp
        bitiş olarak belirtmemiz gereken assertAll() metoduyla test metodumuzdaki bütün assertion'ları
        kontrol eder. Failed olan olursa assertion yaptığımız metodun sonuna yazdığımız mesajı bize
        konsolda verir
         */
        SoftAssert softAssert = new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiginiz kelimeyi icermiyor");

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"WE erisilemez");

        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"SonucWE görüntülenemedi");

        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella icermiyor");
        softAssert.assertAll();
        System.out.println("Hata varsa burası calısmaz");

        // softassert'e bitis satirini soylemek icin assertAll() kullanilir
// bu satir yazilmazsa assertion gorevi yapilmamis olur


/*
Softassert'un hata bulsa bile calismaya devam etme ozelligi
assertAll()'a kadardir.
Eger assertAll()'da failed rapor edilirse calisma durur
ve class'in kalan kismi calistirilmaz
(Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
 */
    }
}
