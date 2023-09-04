package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locator {

    public static void main(String[] args) {

/*Selenium’da kullanilan 8 adet locator vardir.
Bizim test yaparken bu 8 locator’dan hangisinin kullanacagimiz WebElementi unique olarak tarif edebilecegini bulup onu kullanmamiz gerekir.

1- id
WebElement aramaKutusu =
		driver.findElement(By.id (“twotabsearchtextbox"));
2- name
WebElement aramaKutusu =
		driver.findElement(By.name (“field-keywords"));
3- classname
WebElement aramaKutusu =
	driver.findElement(By.classname (“nav-input nav-progressive-					attribute"));
    NOT:Class attribute’u genelde ayni islevi yapan bir grup Web Elementi tanimlamak icin kullanilir ve unique olmaz.
    Class attribute’nun degeri bosluk iceriyorsa, By.classname( ) ile yapilan locator’lar saglikli calismayabilir.
4- tagname
Tag isimleri genelde ayni oldugundan unique degere ulasmak zordur.
5- linkText
WebElement aramaKutusu =
		driver.findElement(By.linkText (“Addresses"));
		NOT: Link uzerindeki bir String oldugundan buyuk,kucuk harf, bosluk gibi durumlara dikkat edilmelidir.

6- partialLinkText
WebElement aramaKutusu =
	driver.findElement(By.partiaLlinkText (“esses"));
7- xpath( )
En guclu locator’dir ve tum webElementleri unique olarak belirleyebilir.
//tagName[@attributeIsmi=‘attributeValue']
WebElement’te kullanilan tag, attribute ve attribute-value ogelerinin birlikte kullanilmasiyla olusur.
WebElement aramaKutusu =
	driver.findElement(By.xpath (“//input[@type=‘text’]"));
8- cssSelector( )
Xpath’e benzer ve tum webElementler icin kullanilabilir. Farki xpath’de kullandigimiz // ve @ isaretinin kullanilmamasidir.
tagName[attributeIsmi=‘attributeValue']
Eger kullanilacak attribute id veya class ise pratik olarak yazilabilir
WebElement aramaKutusu =
driver.findElement(By.cssSelector ("#twotabsearchtextbox’]"));
driver.findElement(By.cssSelector (".nav-input nav-progressive-					attribute]"));
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");


        WebElement deliveryAdress = driver.findElement(By.className("a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss"));
        deliveryAdress.submit();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='nav-bb-search']"));
        searchBox.sendKeys("nutella");
        searchBox.submit();// Enter



    }
}
