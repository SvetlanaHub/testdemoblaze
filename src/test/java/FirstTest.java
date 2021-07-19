import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class FirstTest extends Generator {

    public WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Test start");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");

    }

    @Test //sign up
    public void firstTest() {

        driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(Generator.generate());
        driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(Generator.generate());
        driver.findElement(By.xpath("//button[@onclick=\"register()\"]")).click();

    }

    @Test  //add to cart Nexus 6
    public void addToCartNexus6() {

        driver.findElement(By.xpath("//a[text()[contains(.,'Nexus 6')]]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//font[text()='Корзина']"));

    }

    @Test  //add to cart Iphone 6 32gb
    public void addToCartIphone6() {

        driver.findElement(By.xpath("//*[text()[contains(.,'Iphone 6')]]")).click();
        driver.findElement(By.xpath("//a[@onclick='addToCart(5)']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("cartur")).click();

    }

    @After
    public void close() {

        System.out.println("Test close");
            driver.close();
        driver.quit();

    }
}
