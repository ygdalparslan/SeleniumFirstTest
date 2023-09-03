package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Manage {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        driver.manage().window().maximize();//icinde oldugu sayfayi maximize yapar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        System.out.println(driver.manage().window().getSize());//icinde oldugu sayfanin pixel olarak olculerini döndürür
        System.out.println(driver.manage().window().getPosition());//icinde oldugu sayfanin pixel olarak konumunu döndürür

        driver.manage().window().setPosition(new Point(900,600));//icinde oldugu sayfanin sol alt kosesini bizim yazacagimiz pixel noktasina tasir
        driver.manage().window().setSize(new Dimension(15,15));//icinde oldugu sayfanin sol alt kosesi sabit olarak bizim yazacagimiz olculere getirir

        System.out.println("New Position: " +driver.manage().window().getPosition());
        System.out.println("New Size: "+driver.manage().window().getSize());
        driver.close();


/*      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        implicitlyWait : driver'a sayfanin yuklenmesi ve kullanacagimiz web elementlerin bulunmasi icin
                         bekleyecegi maximum sureyi belirtir.
                         driver bu sure icerisinde sayfa yuklenir/web element bulunursa
                         beklemeden calismaya devam eder.
                         bu sure bittigi halde sayfa yuklenememis/webElement bulunamamissa
                         exception vererek calismayi durdurur

        Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zaman class'idir
                                 Yani driver'a ne kadar bekleyecegini soyler
                                 Duration.ofSeconds(15) yerine milis,minutes,hours da kullanilabilir
 */

/* NOT :    Driver'in istedigimiz islemleri yaparken sorunla karsilasmamasi icin
            driver.manage() method'larindan
            maximize() ve implicitlyWait() method'larinin her test'te kullanilmasi
            FAYDALI OLACAKTIR

 */
    }
}
