package ecommercewebsitetesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("http://leaftaps.com/opentaps/control/login");
// Enter the username and password.
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
//Click on the Login button. 
driver.findElement(By.className("decorativeSubmit")).click();
//Click on the CRM/SFA link. 
driver.findElement(By.linkText("CRM/SFA")).click();
// - Click on the Contacts button. 
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
// Click on Merge Contacts. 
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

//Click on the widget of the "From Contact".
driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
Thread.sleep(3000); 

//Click on the first resulting contact
Set<String> windowHandles = driver.getWindowHandles();
List<String>window =new ArrayList<>( windowHandles);
 driver.switchTo().window(window.get(1));
 WebElement element = driver.findElement(By.xpath("//a[text()='DemoCustomer']"));
 element.click();
 driver.switchTo().window(window.get(0));
 
 //Click on the widget of the" To contact"
 driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
 Thread.sleep(3000);
 
 //click on the second resulting contact
 Set<String> windowHandles2 = driver.getWindowHandles();
 List<String>window2=new ArrayList<>( windowHandles2);
 driver.switchTo().window(window2.get(1));
 Thread.sleep(3000);
 WebElement element2 = driver.findElement(By.xpath("//a[text()='dp1a1contact2']"));
element2.click();
driver.switchTo().window(window2.get(0));

// Click on the Merge button. 
   driver.findElement(By.xpath("//a[text()='Merge']")).click();
// Accept the alert.
   Alert alert = driver.switchTo().alert();
  alert.accept();
// Verify the title of the page. 
   System.out.println("Title :"+ driver.getTitle());
		

	}

}
