package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElement03 {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");
        // 2- cookies cikarsa kabul et butonuna basin

        // 3- sayfada kac adet button bulundugunu yazdirin
        List<WebElement> buttons = driver.findElements(By.tagName("Button"));
        System.out.println(buttons.size());

        // 4- sayfadaki herbir button uzerindeki yazilari yazdirin

        for (WebElement w:buttons) {
            System.out.println(w.getText());
        }

        driver.close();
    }
}
