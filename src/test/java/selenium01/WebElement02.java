package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElement02 {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        // cookies cikarsa kabul et butonuna basin
//        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
        // e-posta kutusuna rastgele bir mail girin
        WebElement email =driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        email.sendKeys("ajjjkkkkkkkkk");
        // sifre kismina rastgele bir sifre girin
        WebElement password = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        password.sendKeys("dkdkdk11");
        // giris yap butonuna basin
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")).click();
        // uyari olarak "Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap."
        //  mesajinin ciktigini test edin
        WebElement result = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        System.out.println(result.getText());

        String expectedResult ="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualResult =result.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("girilemedi testi passed");

        }else {
            System.out.println("girilemedi testi failed");
        }

        // sayfayi kapatin
        driver.close();



    }
}
