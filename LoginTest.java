package org.example;
import org.openqa.selenium.By; //Selenium'da, web sayfasındaki elemanları seçmek için kullanılan bir sınıftır.
import org.openqa.selenium.WebDriver; //Web tarayıcıları üzerinde otomatik testler yapmanızı sağlayan arayüzdür
import org.openqa.selenium.WebElement; //Web sayfasındaki bir elemanla etkileşime girmenize olanak sağlar
import org.openqa.selenium.chrome.ChromeDriver; //Selenium, bu sınıfı kullanarak Chrome tarayıcısında testleri çalıştırır
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        // Kullanıcı adı gir
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        // Şifre gir
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        // Giriş butonuna tıkla
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));
        loginButton.click();

        // Başarı mesajını kontrol et
        WebElement successMessage = driver.findElement(By.id("flash"));
        String messageText = successMessage.getText();

        if (messageText.contains("You logged into a secure area!")) {
            System.out.println("✅ Login başarılı.");
        } else {
            System.out.println("❌ Login başarısız.");
        }

        // Tarayıcıyı kapat
        driver.quit();
    }
}
