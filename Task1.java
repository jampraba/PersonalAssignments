package reciepe;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
	public static void main(String[] args) throws InterruptedException {
		 ChromeOptions cp=new ChromeOptions();
		  cp.addArguments("--disable notifications");
		   cp.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver=new ChromeDriver(cp);		   

 
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 driver.get("https://chat.deepseek.com/");
 Thread.sleep(3000);
 Thread.sleep(15000);
 driver.manage().window().maximize();
 driver.findElement(By.xpath("//input[@placeholder='Phone number / email address']")).sendKeys("jamunaaprabakaran@gmail.com");
 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456jamu");
 driver.findElement(By.xpath("//div[text()='Log in']")).click();
 driver.findElement(By.id("chat-input")).sendKeys("Give me a classic frenchfries",Keys.ENTER);
 Thread.sleep(40000);
 String text = driver.findElement(By.xpath("//div[@class='ds-markdown ds-markdown--block']")).getText();
 System.out.println(text);

}
}