package seleniumJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JunitAssertion {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Test
    public void test01() {
        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//span[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']")).click();

        //2- arama cubuguna “Nutella” yazdirin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");
        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        searchBox.submit();
        //4- Bulunan sonuc yazisinin "Nutella" icerdigini test edelim
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedText ="Nutella";

        String actualText = resultText.getText();

        if (actualText.contains("kutella")){
            System.out.println("Nutella testi PASSED");

        }else {
            System.out.println("Sonuc yazisi Nutella icermiyor" +
                    "\nNutella testi FAILED");
        }




    }
}
