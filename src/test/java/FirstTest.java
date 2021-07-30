
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FirstTest extends Generator {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp() {

        driver.get("https://www.demoblaze.com/");

    }

    @Test
    @Order(1)
    @DisplayName("We check that the user can sign in to the site")
    public void firstTest() {

        driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(Generator.generate());
        driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(Generator.generate());
        driver.findElement(By.xpath("//button[@onclick=\"register()\"]")).click();

    }

    @Test
    @Order(2)
    @DisplayName("Checking the addition of the phone to the cart")
    public void addToCartNexus6() {

        driver.findElement(By.xpath("//a[text()[contains(.,'Nexus 6')]]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//font[text()='Корзина']"));

    }

    @Test
    @Order(3)
    @DisplayName("Checking the addition of the phone to the cart")
    public void addToCartIphone6() {

        driver.findElement(By.xpath("//*[text()[contains(.,'Iphone 6')]]")).click();
        driver.findElement(By.xpath("//a[@onclick='addToCart(5)']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("cartur")).click();

    }

    @AfterAll
    public void close() {

        System.out.println("Test close");
            driver.close();
        driver.quit();

    }
}
