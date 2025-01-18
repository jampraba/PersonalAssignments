package ecommercewebsitetesting;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Bigbasket {

	public static void main(String[] args) throws InterruptedException , IOException {
	 WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.navigate().to(" https://www.bigbasket.com/");
		Actions action =new Actions(driver);
//Click on "Shop by Category". 
		WebElement shop = driver.findElement(By.xpath("(//span[contains(text(),'Shop by')])[2]"));
		shop.click();
		Thread.sleep(900);		
//Mouse over "Foodgrains, Oil & Masala". 
		WebElement fg = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		action.moveToElement(fg).perform();
		
//Mouse over "Rice & Rice Products". 
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Rice & Rice Products'])[1]"))).perform();
//Click on "Boiled & Steam Rice". 
			driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		
//Filter the results by selecting the brand "bb Royal". 
action.scrollToElement(driver.findElement(By.xpath("//span[text()='Brands']"))).perform();
driver.findElement(By.xpath("//input[@class=\"flex-1 min-w-0 leading-md lg:text-sm xl:text-md placeholder-silverSurfer-700\"]")).sendKeys("bb royal");
driver.findElement(By.xpath("//input[@id=\"i-BBRoyal\"]")).click();
Thread.sleep(700);

//Click on "Tamil Ponni Boiled Rice".//next tab open we use window handle
driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
Set<String> allWindowHandles = driver.getWindowHandles();
String originalhandle = driver.getWindowHandle();
for (String handle : allWindowHandles) {
	if (!handle.equals(originalhandle)) {
		driver.switchTo().window(handle);
		break;
		
	}
}

// Select the 5 Kg bag. 

// Check and note the price of the rice.
//WebElement pr = driver.findElement(By.xpath("(//div[@class='flex flex-col gap-0.5']"));
//System.out.println("Price is :"+ pr.getText());

// Click "Add" to add the bag to your cart.
//driver.findElement(By.xpath("//button[text()='Add to basket']")).click();

// Verify the success message that confirms the item was added to your cart. 
//WebElement p = driver.findElement(By.xpath("//p[@class=\"mx-4 flex-1\"]"));
//System.out.println(p.getText());
//Thread.sleep(1000);

// Take a snapshot of the current page 
		
// Close the current window. 
			//driver.close();
		
// Close the main window.
			//driver.quit();
	}

}
