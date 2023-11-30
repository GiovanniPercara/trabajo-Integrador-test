package enterWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://magento.softwaretestingboard.com/");

        driver.manage().window().fullscreen();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Seleccionar la prenda "Radiant Tee"
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Radiant Tee")));
        product.click();


        // Configurar las opciones de la prenda
        // Tamaño: L
        WebElement size = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size-143-item-169")));
        size.sendKeys("L");
        size.click();

        // Color: Azul
        WebElement color = driver.findElement(By.id("option-label-color-93-item-50"));
        color.sendKeys("Azul");
        color.click();

        // Cantidad: 2
        WebElement quantity = driver.findElement(By.name("qty"));

        quantity.clear();
        quantity.sendKeys("2");

        // Hacer click en "Add to Cart"
        WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
        addToCart.click();

        // Hacer click en el enlace "shopping cart"
        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart")));
        shoppingCart.click();

        // Hacer clic en "Proceed to Checkout"
        WebElement proceedToCheckout = driver.findElement(By.cssSelector("button[data-role='proceed-to-checkout']"));
        proceedToCheckout.click();

        // Ingresar tu dirección de correo electrónico
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email")));
        email.sendKeys("giovanni.percara@gmail.com");

        // Ingresar tu nombre
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Giovanni");

        // Ingresar tu apellido
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Percara");

        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("Estudent");

        // Ingresar tu calle
        WebElement street = driver.findElement(By.name("street[0]"));
        street.sendKeys("calle matusalem 124");

        // Ingresar tu ciudad

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Concordia");

        // Ingresar tu pais
        WebElement country = driver.findElement(By.name("country_id"));
        Select countryList = new Select(country);
        countryList.selectByValue("AR");


        // Ingresar tu provincia
        WebElement province = driver.findElement(By.name("region"));
        province.sendKeys("Entre Rios");

        // Ingresar tu codigo postal
        WebElement postalCode = driver.findElement(By.name("postcode"));
        postalCode.sendKeys("93341");

        // Ingresar tu numero de telefono
        WebElement phoneNumber = driver.findElement(By.name("telephone"));
        phoneNumber.sendKeys("345 4298132");

        // Metodo de compra
        WebElement shipping = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#label_method_flatrate_flatrate")));
        shipping.click();

        // Hacer clic en "Next"
        WebElement next = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='button action continue primary']")));
        next.click();

        // Hacer clic en "Place Order"
        WebElement order = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[span='Place Order']")));
        order.click();

    }
    }
